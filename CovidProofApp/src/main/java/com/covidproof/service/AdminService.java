package com.covidproof.service;

import com.covidproof.exception.AdminException;
import com.covidproof.model.DTO.AdminLoginDTO;
import com.covidproof.model.DTO.AdminPasswordDTO;
import com.covidproof.model.Entity.Admin;
import com.covidproof.model.Entity.CurrentSession;


public interface AdminService {
	//Register Admin
	public Admin registerAdmin(Admin admin)throws AdminException;
	//Login Admin
	public Admin loginAdmin(AdminLoginDTO aLoginDto) throws AdminException;
	//LogOut Admin
	public Admin logoutAdmin(String key)throws AdminException;
	//Updated Admin Password
	public Admin updatePassword(AdminPasswordDTO aPassDto) throws AdminException;
    //Admin Current Session
	public CurrentSession adminSession(String mobile) throws AdminException;
    
}
