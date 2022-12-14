package com.covidproof.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidproof.dao.dao;
import com.covidproof.model.Entity.Admin;

@Service
public class testImpl implements testService{
	@Autowired
	private dao dao;

	@Override
	public String saveAd(Admin a) {
		Admin admin=dao.save(a);
		return admin.toString();
	}
	
}
