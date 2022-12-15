package com.covidproof.service;

import java.util.List;

import com.covidproof.exception.VaccineCenterException;
import com.covidproof.model.Entity.VaccineCenter;

public interface VaccineCenterService {
	public VaccineCenter addVaccineCenter(VaccineCenter vCenter) throws VaccineCenterException;
	public VaccineCenter updateVaccineCenter(VaccineCenter vCenter) throws VaccineCenterException;
	public VaccineCenter deleteVaccineCenter(Integer centerCode) throws VaccineCenterException;
	public VaccineCenter getVaccineById(Integer centerCode) throws VaccineCenterException;
	public List<VaccineCenter> getAllVaccineCenter() throws VaccineCenterException;
	
	
}
