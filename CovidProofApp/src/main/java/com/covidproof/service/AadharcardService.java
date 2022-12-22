package com.covidproof.service;

import com.covidproof.exception.AadharException;
import com.covidproof.model.Entity.AadharCard;

public interface AadharcardService {
	//Add AadharCard of Applicant
	public AadharCard addAadharCard(AadharCard ac) throws AadharException;
	
	//Get AadharCard Details by Aadhar number
	public AadharCard getAadharCard(Long adNo) throws AadharException;
	
	//Check AadharaCard is registered or Not
	public Boolean checkIfRegistered(Long adNo);
}
