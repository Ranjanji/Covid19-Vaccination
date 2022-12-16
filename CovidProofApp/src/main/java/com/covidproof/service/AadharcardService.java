package com.covidproof.service;

import com.covidproof.model.Entity.AadharCard;

public interface AadharcardService {
	public AadharCard addAadharCard(AadharCard ac);
	public AadharCard getAadharCard(Long num);
	public Boolean checkIfRegistered(Long num);
}
