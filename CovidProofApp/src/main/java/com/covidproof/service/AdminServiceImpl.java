package com.covidproof.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidproof.dao.AdminDAO;
import com.covidproof.exception.AdminException;
import com.covidproof.model.Entity.Admin;
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO dao;

	@Override
	public Admin registerAdmin(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		Admin admin2=dao.save(admin);
		if(admin2==null) {
			throw new AdminException("Moblie Password Not Match.");
		}
		return admin2;
	}

	@Override
	public Admin loginAdmin(String mobile, String password) throws AdminException {
		// TODO Auto-generated method stub
		Admin admin=dao.loginAdmin(mobile, password);
		if(admin==null) {
			throw new AdminException("Moblie Password Not Match.");
		}
		return admin;
	}

	@Override
	public Admin updatePassword(String mobile, String old_pass, String new_pass) throws AdminException {
		// TODO Auto-generated method stub
		Admin admin=dao.loginAdmin(mobile, old_pass);
		if(admin==null) {
			throw new AdminException("Moblie Password Not Match.");
		}
		admin.setPassword(new_pass);
		return dao.save(admin);
	}

}
