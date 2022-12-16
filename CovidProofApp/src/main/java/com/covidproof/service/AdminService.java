package com.covidproof.service;

import com.covidproof.exception.AdminException;
import com.covidproof.model.DTO.AdminLoginDTO;
import com.covidproof.model.DTO.AdminPasswordDTO;
import com.covidproof.model.Entity.Admin;


public interface AdminService {
	public Admin registerAdmin(Admin admin)throws AdminException;
	public Admin loginAdmin(AdminLoginDTO aLoginDto) throws AdminException;
	public Admin updatePassword(AdminPasswordDTO aPassDto) throws AdminException;
    public String adminSession(String mobile) throws AdminException;
}
