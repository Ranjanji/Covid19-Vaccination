package com.covidproof.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidproof.dao.ApplicantDAO;
import com.covidproof.exception.ApplicantException;
import com.covidproof.model.Entity.Dose;
import com.covidproof.model.Entity.IdCard;

@Service
public class ApplicantServiceImpl implements ApplicantService {
	@Autowired
	private ApplicantDAO adao;

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
			throw new ApplicantException("Login failed. Incorrect mobile number, dob or both.");
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
		IdCard existingApplicant = adao.findByMobile(mobile);
		if(existingApplicant!=null) {
			String name = existingApplicant.getName();
			Set<Dose> doses = existingApplicant.getDoses();
			
			Dose[] dosesArr = doses.toArray(new Dose[doses.size()]);
			
			int doseCount1 = dosesArr[0].getDoseCount();
			String doseStatus1 = dosesArr[0].getDoseStatus();
			
			int doseCount2 = dosesArr[1].getDoseCount();
			String doseStatus2 = dosesArr[1].getDoseStatus();
			
			String vaccineName = dosesArr[0].getVaccine().getName();
			
			String str1 = "ApplicantName: "+name+", DoseCount1: "+doseCount1+", DoseStatus1: "+doseStatus1+", VaccineName: "+vaccineName;
			String str2 = "ApplicantName: "+name+", DoseCount2: "+doseCount2+", DoseStatus2: "+doseStatus2+", VaccineName: "+vaccineName;
			
			List<String> list = new ArrayList<>();
			list.add(str1);
			list.add(str2);
			return list;
		} else {
			throw new ApplicantException("No applicant found with this moble number: "+mobile);
		}
	}

	@Override
	public String cancelAppointment(String mobile, LocalDate dob) throws ApplicantException {
		IdCard existingApplicant =  adao.findByMobile(mobile);
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
