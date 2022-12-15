package com.covidproof.service;

import java.time.LocalDate;
import java.util.List;

import com.covidproof.exception.ApplicantException;
import com.covidproof.exception.VaccineException;
import com.covidproof.model.Entity.IdCard;
import com.covidproof.model.Entity.Vaccine;

public interface ApplicantService {

	// Registering an Applicant
	// Parameter --> IdCard object
	// Return --> Registered Applicant
	public IdCard registerAnApplicant(IdCard idCard) throws ApplicantException;
	
	// Applicant Login
	public IdCard loginApplicant(String mobile, LocalDate dob) throws ApplicantException;
	
    // Get applicant by id
	public IdCard getApplicantById(Integer id) throws ApplicantException;
	
	// Update applicant details
	public IdCard updateApplicantDetails(IdCard idCard) throws ApplicantException;
	
	// Checking vaccination status
	public List<String> getVaccinationStatus(String mobile) throws ApplicantException;
	
	// Canceling appointment
	public String cancelAppointment(String mobile, LocalDate dob) throws ApplicantException;
	
	// Change slot
	public String changeSlot(String mobile, LocalDate dob, LocalDate newDate, String newSlot) throws ApplicantException;
	
	// If applicant wants to know about all kinds of available vaccines
	public List<Vaccine> getAllVaccineDetails() throws VaccineException;
	
	
}
