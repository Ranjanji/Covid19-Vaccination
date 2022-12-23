package com.covidproof.service;

import java.time.LocalDate;
import java.util.List;

import com.covidproof.exception.ApplicantException;
import com.covidproof.exception.VaccineException;
import com.covidproof.model.Entity.Appointment;
import com.covidproof.model.Entity.Dose;
import com.covidproof.model.Entity.IdCard;
import com.covidproof.model.Entity.Vaccine;

public interface ApplicantService {

	// Registering an Applicant
	// Parameter --> IdCard object
	// Return --> Registered Applicant
	public IdCard registerAnApplicant(IdCard idCard,Long adno) throws ApplicantException;
	
	//get all Applicant Details
	public List<IdCard> getAllIdCards() throws ApplicantException;
		
	// Applicant Login
	public IdCard loginApplicant(String mobile, LocalDate dob) throws ApplicantException;
	
	//delete Applicant Details
		public Boolean deleteCard(Integer id) throws ApplicantException;
	
    // Get applicant by id
	public IdCard getApplicantById(Integer id) throws ApplicantException;
	
	// Update applicant details
	public IdCard updateApplicantDetails(IdCard idCard) throws ApplicantException;
	
	//Apply for vaccination
		public IdCard applyForVaccination(Integer id,Integer vid,Integer vcid,Integer dose,Appointment appointment) throws ApplicantException;
	
	// Checking vaccination status
	public List<String> getVaccinationStatus(String mobile) throws ApplicantException;
	
	// Canceling appointment
	public String cancelAppointment(Integer id) throws ApplicantException;
	
	// Change slot for appointment
	public Appointment changeSlot(Appointment appointment) throws ApplicantException;
	
	// If applicant wants to know about all kinds of available vaccines
	public List<Vaccine> getAllVaccineDetails() throws VaccineException;
	
	
}
