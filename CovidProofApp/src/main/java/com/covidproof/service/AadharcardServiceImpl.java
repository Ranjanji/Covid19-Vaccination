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

	@Override
	public AadharCard addAadharCard(AadharCard ac) {
		AadharCard aadharCard=dao.save(ac);
		
		return aadharCard;
	}

	@Override
	public AadharCard getAadharCard(Long num) throws AadharException{
		Optional<AadharCard> optional=dao.findById(num);
		
	    AadharCard ac=optional.get();
	    if(ac==null) {
	    	throw new AadharException("Aadhar card Not Registered");
	    }
		return ac;
	}

	@Override
	public Boolean checkIfRegistered(Long num) {
		// TODO Auto-generated method stub
		Optional<AadharCard> optional=dao.findById(num);
	    AadharCard ac=optional.get();
	    if(ac==null) {
	    	return false;
	    }
		return true;
	}

}
