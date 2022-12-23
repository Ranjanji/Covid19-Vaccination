package com.covidproof.service;


import java.lang.StackWalker.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidproof.dao.AadharDAO;
import com.covidproof.exception.AadharException;
import com.covidproof.model.Entity.AadharCard;

@Service
public class AadharcardServiceImpl implements AadharcardService {
	
	@Autowired
	private AadharDAO dao;

	//Add AadharCard of Applicant
	@Override
	public AadharCard addAadharCard(AadharCard ac) {
		if(checkIfRegistered(ac.getAdNo())) throw new AadharException("Aadhar card Already Registered");
		
		AadharCard aadharCard=dao.save(ac);
		return aadharCard;
	}

	//Get AadharCard Details by Aadhar number
	@Override
	public AadharCard getAadharCard(Long num) throws AadharException{
		Optional<AadharCard> optional=dao.findById(num);
		
	    AadharCard ac=optional.get();
	    if(ac==null) {
	    	throw new AadharException("Aadhar card Not Registered");
	    }
		return ac;
	}

	//Check AadharaCard is registered or Not
	@Override
	public Boolean checkIfRegistered(Long num) {
		return dao.findById(num).isPresent();   
	}

}
