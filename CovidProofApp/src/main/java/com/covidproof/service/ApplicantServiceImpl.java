package com.covidproof.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.hibernate.boot.model.relational.SimpleAuxiliaryDatabaseObject;
import org.hibernate.loader.AbstractEntityJoinWalker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidproof.dao.AadharDAO;
import com.covidproof.dao.ApplicantDAO;
import com.covidproof.dao.AppointmentDAO;
import com.covidproof.dao.DoseDAO;
import com.covidproof.dao.VaccineCenterDAO;
import com.covidproof.dao.VaccineDAO;
import com.covidproof.exception.AadharException;
import com.covidproof.exception.ApplicantException;
import com.covidproof.exception.DoseException;
import com.covidproof.exception.VaccineCenterException;
import com.covidproof.exception.VaccineException;
import com.covidproof.model.Entity.AadharCard;
import com.covidproof.model.Entity.Appointment;
import com.covidproof.model.Entity.Dose;
import com.covidproof.model.Entity.IdCard;
import com.covidproof.model.Entity.Vaccine;
import com.covidproof.model.Entity.VaccineCenter;
import com.covidproof.model.NonEntity.Status;

@Service
public class ApplicantServiceImpl implements ApplicantService {
	@Autowired
	private ApplicantDAO adao;
	@Autowired
	private AadharDAO addao;
	@Autowired
	private AppointmentDAO appdao;
		
	@Autowired
	private VaccineDAO vdao;
	
	@Autowired
	private VaccineCenterDAO vcdao;
	
	@Autowired
	private DoseDAO doseDAO;

	@Override
	public IdCard applyForVaccination(Integer id,Integer vid, Integer vcid, Integer dose, Appointment appointment)
			throws ApplicantException {
		if(dose==0 || dose>2) {
			throw new DoseException("Dose can be 1 or 2 !!!");
		}
		Optional<IdCard> idcardOptional=adao.findById(id);
		IdCard idCard=idcardOptional.get();
		if(idCard==null) {
			throw new ApplicantException("Applicant Id is Not Correct");
		}
		List<Dose> doses=idCard.getDoses();
		if(doses.size()>=2) {
			throw new DoseException("Both the Doses Already Taken");
		}else if(doses.size()==1) {
			
			if(dose==1) {
				throw new DoseException("First Dose Already Taken");
			}
			Dose tempDose=doses.get(0);
			if(tempDose.getDoseStatus().equals(Status.PENDING.toString())) {
				throw new DoseException("First Dose is PENDING!! You cant apply for Second");
			}
		}else if(dose==2 && doses.size()==0) {
			throw new DoseException("Dose 1 not taken!! you cant apply for dose 2...");
		}
		
		Optional<Vaccine> vaccOptional=vdao.findById(vid);
		Vaccine vaccine=vaccOptional.get();
		if(vaccine==null) {
			throw new VaccineException("Vaccine is Not Available");
		}
		Optional<VaccineCenter> vsOptional=vcdao.findById(vcid);
		VaccineCenter vaccineCenter=vsOptional.get();
		if(vaccineCenter==null) {
			throw new VaccineCenterException("VaccineCenter is Not Available");
		}
		Dose doseObj=new Dose();
		doseObj.setAppointment(appointment);
		doseObj.setCenter(vaccineCenter);
		doseObj.setDoseCount(dose);
		doseObj.setVaccine(vaccine);
//		doseObj.setIdCard(idCard);
		doseObj.setDoseStatus(Status.PENDING.toString());
		
		doses.add(doseObj);
		appointment.setBookingStatus(Status.COMPLETED.toString());
		
		//Validation of slot availability
		List<Dose> dosesOfCenter=doseDAO.findByCenter(vaccineCenter);
		for(Dose d:dosesOfCenter) {
			Appointment app=d.getAppointment();
			String status=d.getDoseStatus();
			LocalDate date=app.getDate();
			String slot=app.getSlot();
			if(date.toString().equals(appointment.getDate().toString())) {
				if(status.equals(Status.PENDING.toString())) {
					if(slot.equals(appointment.getSlot())) {
						throw new DoseException("Slot Already Booked!!");
					}
				}
			}
		}
		adao.save(idCard);
//		doseDAO.save(doseObj);
//		appdao.save(appointment);
		 
		return idCard;
	}
	@Override
	public IdCard registerAnApplicant(IdCard idCard,Long adno) throws ApplicantException,AadharException {
		Optional<AadharCard> op=addao.findById(adno);
	    if(op.isPresent())
	    	throw new AadharException("AadharCard is Already Registered!!");
	    AadharCard ac=new AadharCard();
	    ac.setAdNo(adno);
	    ac.setMobile(idCard.getMobile());
//	    ac.setIdCard(idCard);
	    idCard.setAadharcard(ac);
	    addao.save(ac);
		IdCard registeredApplicant = adao.save(idCard);
		if(registeredApplicant!=null) {
			return registeredApplicant;
		} else {
			throw new ApplicantException("Registration failed! Please try again with valid credentials. :)");
		}
	}

	@Override
	public IdCard loginApplicant(String mobile, LocalDate dob) throws ApplicantException {
		IdCard applicant = adao.findByMobAndDob(mobile, dob);
		if(applicant!=null) {
			return applicant;
		} else {
			throw new ApplicantException("Login failed. Incorrect mobile number or incorrect dob or both.");
		}
	}

	@Override
	public IdCard getApplicantById(Integer id) throws ApplicantException {
		Optional<IdCard> opt = adao.findById(id);
		if(opt!=null) {
			IdCard existingApplicant = opt.get();
			return existingApplicant;
		} else {
			throw new ApplicantException("No applicant found with this Id");
		}
	}

	@Override
	public IdCard updateApplicantDetails(IdCard idCard) throws ApplicantException {
		IdCard updatedApplicantDetails = adao.save(idCard);
		if(updatedApplicantDetails!=null) {
			return updatedApplicantDetails;
		} else {
			throw new ApplicantException("No such applicant found."+idCard);
		}
	}

	@Override
	public List<String> getVaccinationStatus(String mobile) throws ApplicantException {
		
		// Written this method assuming only 2 doses will be provided to user
		// if we consider total 3 doses then this method should be changed a little.
		
		IdCard existingApplicant = adao.findByMobile(mobile);
		if(existingApplicant!=null) {
			String name = existingApplicant.getName();
			List<Dose> doses = existingApplicant.getDoses();
			
			Dose[] dosesArr = doses.toArray(new Dose[doses.size()]);
			
			List<String> list = new ArrayList<>();
			
			for(int i=0;i<doses.size();i++) {
				int doseCount = dosesArr[i].getDoseCount();
				String doseStatus = dosesArr[i].getDoseStatus();
				
				String vaccineName = dosesArr[i].getVaccine().getName();
				
				String str = "ApplicantName: "+name+", DoseCount: "+doseCount+", DoseStatus: "+doseStatus+", VaccineName: "+vaccineName;
				
				list.add(str);
			}
			
			return list;
		} else {
			throw new ApplicantException("No applicant found with this moble number: "+mobile);
		}
	}

	@Override
	public String cancelAppointment(String mobile, LocalDate dob) throws ApplicantException {
		IdCard existingApplicant =  adao.findByMobAndDob(mobile, dob);
		
		if(existingApplicant!=null) {
			List<Dose> doses = existingApplicant.getDoses();
			Dose[] dosesArr = doses.toArray(new Dose[doses.size()]);
			
			for(int i=0;i<dosesArr.length;i++) {
				if(dosesArr[i].getDoseStatus()=="Pending") {
					Appointment appointment = dosesArr[i].getAppointment();
					if(appointment.getBookingStatus()=="Booked") {
						appointment.setBookingStatus("Available");
						return "Appointment Cancelled.";
					} else {
						return "Appointment not yet booked. Please book first.";
					}
				}
			}
			return "You have already taken all your doses.";
		} 
		else {
			throw new ApplicantException("Incorrect mobile number or incorrect dob or both. Please try again.");
			
		}
	}

	
	
	// If applicant wants to know about all kinds of available vaccines
	@Override
	public List<Vaccine> getAllVaccineDetails() throws VaccineException {
		List<Vaccine> vaccineList = vdao.findAll();
		if(vaccineList.isEmpty()) {
			throw new VaccineException("No vaccine details available for now.");
		} else {
			return vaccineList;
		}
	}

	public List<IdCard> getAllIdCards() throws ApplicantException {
		// TODO Auto-generated method stub
		List<IdCard> list=adao.findAll();
		if(list.size()==0) {
			throw new ApplicantException("No Applicant Details");
		}
		return list;
	}

	@Override
	public Boolean deleteCard(Integer id) throws ApplicantException {
		// TODO Auto-generated method stub
		Optional<IdCard> opt=adao.findById(id);
		IdCard card=opt.get();
		if(card==null) {
			throw new ApplicantException("Applicant Id is not Correct");
		}
		adao.delete(card);
		return true;
	}

	
	public String changeSlot(String mobile, LocalDate dob, LocalDate newDate, String newSlot) throws ApplicantException {
		IdCard existingApplicant =  adao.findByMobAndDob(mobile, dob);
		
		if(existingApplicant!=null) {
			List<Dose> doses = existingApplicant.getDoses();
			Dose[] dosesArr = doses.toArray(new Dose[doses.size()]);
			
			for(int i=0;i<dosesArr.length;i++) {
				Appointment appointment = dosesArr[i].getAppointment();
				if(dosesArr[i].getDoseStatus()=="Pending") {
					Appointment requirdeAppointment = appdao.getAppointmentByDateAndSlot(newDate, newSlot);
					if(requirdeAppointment.getBookingStatus()=="Available") {
						requirdeAppointment.setBookingStatus("Booked");
						dosesArr[i].getAppointment().setDate(newDate);
						dosesArr[i].getAppointment().setSlot(newSlot);
						dosesArr[i].getAppointment().setBookingStatus("Available");		
						return "New slot booked. "+newDate+" and "+newSlot;
						} else {
							return "This slot is already booked. Please try another one.";
						}
				}
			}
			return "You have already taken all your doses. Not applicable.";
		}
		else {
			throw new ApplicantException("Incorrect mobile number or incorrect dob or both. Please try again.");
		}
		
	}

	
}
