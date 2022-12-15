package com.covidproof.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidproof.dao.ApplicantDAO;
import com.covidproof.dao.AppointmentDAO;
import com.covidproof.dao.VaccineDAO;
import com.covidproof.exception.ApplicantException;
import com.covidproof.exception.VaccineException;
import com.covidproof.model.Entity.Appointment;
import com.covidproof.model.Entity.Dose;
import com.covidproof.model.Entity.IdCard;
import com.covidproof.model.Entity.Vaccine;

@Service
public class ApplicantServiceImpl implements ApplicantService {
	@Autowired
	private ApplicantDAO adao;
	
	@Autowired
	private AppointmentDAO appdao;
	
	@Autowired
	private VaccineDAO vdao;

	@Override
	public IdCard registerAnApplicant(IdCard idCard) throws ApplicantException {
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
			Set<Dose> doses = existingApplicant.getDoses();
			
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
			Set<Dose> doses = existingApplicant.getDoses();
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

	@Override
	public String changeSlot(String mobile, LocalDate dob, LocalDate newDate, String newSlot) throws ApplicantException {
		IdCard existingApplicant =  adao.findByMobAndDob(mobile, dob);
		
		if(existingApplicant!=null) {
			Set<Dose> doses = existingApplicant.getDoses();
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
	
}
