package com.covidproof.service;

import java.util.List;

import com.covidproof.exception.VaccineCenterException;
import com.covidproof.model.Entity.VaccineCenter;

public interface VaccineCenterService {
	//Add Vaccine Center Details
	public VaccineCenter addVaccineCenter(VaccineCenter vCenter) throws VaccineCenterException;
	
	//Update Vaccine Center Details
	public VaccineCenter updateVaccineCenter(VaccineCenter vCenter) throws VaccineCenterException;
	
	//Delete Vaccine Center Details
	public VaccineCenter deleteVaccineCenter(Integer centerCode) throws VaccineCenterException;
	
	//Get Vaccine Center Details by center code
	public VaccineCenter getVaccineById(Integer centerCode) throws VaccineCenterException;
	
	//Get all Vaccine Center Details
	public List<VaccineCenter> getAllVaccineCenter() throws VaccineCenterException;
	
	//get center code(id) by Name 
	public Integer getVCIdByName(String name);
}
