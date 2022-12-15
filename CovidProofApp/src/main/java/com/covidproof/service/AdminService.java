package com.covidproof.service;

import com.covidproof.exception.AdminException;
import com.covidproof.model.Entity.Admin;

public interface AdminService {
	public Admin registerAdmin(Admin admin)throws AdminException;
	public Admin loginAdmin(String mobile,String password) throws AdminException;
	public Admin updatePassword(String mobile,String old_pass,String new_pass) throws AdminException;
}
