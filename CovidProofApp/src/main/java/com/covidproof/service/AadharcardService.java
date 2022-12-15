package com.covidproof.service;

import com.covidproof.model.Entity.AadharCard;

public interface AadharcardService {
	public AadharCard addAadharCard(AadharCard ac);
	public AadharCard getAadharCard(Integer num);
	public Boolean checkIfRegistered(Integer num);
}
