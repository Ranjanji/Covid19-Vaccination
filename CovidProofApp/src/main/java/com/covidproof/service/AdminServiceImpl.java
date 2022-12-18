package com.covidproof.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidproof.dao.AdminDAO;
import com.covidproof.dao.CurrentSessionDAO;
import com.covidproof.exception.AdminException;
import com.covidproof.model.DTO.AdminLoginDTO;
import com.covidproof.model.DTO.AdminPasswordDTO;
import com.covidproof.model.Entity.Admin;
import com.covidproof.model.Entity.CurrentSession;

import net.bytebuddy.utility.RandomString;
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO dao;
	
	@Autowired
	private CurrentSessionDAO csDao;
	
//Admin Registration
	@Override
	public Admin registerAdmin(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		Admin admin3=dao.findByMobile(admin.getMobile());
		if(admin3==null)
			throw new AdminException("Mobile Already Registered");
		Admin admin2=dao.save(admin);
		if(admin2==null) {
			throw new AdminException("Enter Valid Moblie Number or Password.");
		}
		return admin2;
	}
//Admin Login Using Admin DTO for security purposes
//Admin Session is also checked 	
	@Override
	public Admin loginAdmin(AdminLoginDTO aLoginDto) throws AdminException {
		
		Admin admin=dao.findByMobile(aLoginDto.getMobile());
		if(admin==null) {
			throw new AdminException("Please Enter a valid Mobile Number.");
		}
		
       Optional<CurrentSession> adminSession =   csDao.findById(admin.getAdminId());
		
		if(adminSession.isPresent()) {
			
			throw new AdminException("User already Logged In with this number");
			
		}
			if(admin.getPassword().equals(aLoginDto.getPassword())) { 
				String key=RandomString.make(6);
				
				CurrentSession currentUserSession = new CurrentSession(admin.getAdminId(),key,LocalDateTime.now());
				
				csDao.save(currentUserSession);

			}
			else throw new AdminException("Please Enter a valid password");
		
		return admin;
	}
//Admin Update Password Using AdminPasswordDTO for security purposes
	@Override
	public Admin updatePassword(AdminPasswordDTO aPassDto) throws AdminException {
        
		Admin admin=dao.findByMobile(aPassDto.getMobile());
		if(admin==null) {
			throw new AdminException("Please Enter a valid Mobile Number");
		}
        Optional<CurrentSession> adminSession =   csDao.findById(admin.getAdminId());
		
		if(adminSession.isPresent()) {
			if(admin.getPassword().equals(aPassDto.getOld_pass())) {
				admin.setPassword(aPassDto.getNew_pass());
			}
			else throw new AdminException("Please Enter a valid Old Password");
		}
		else throw new AdminException("Please Login First");
		return dao.save(admin);
		
	}
	@Override
	public CurrentSession adminSession(String mobile) throws AdminException {
		Admin admin=dao.findByMobile(mobile);
		if(admin==null) throw new AdminException("Please Enter a valid Mobile Number/////");
		
		Optional <CurrentSession> userSession=csDao.findById(admin.getAdminId());
		if(!userSession.isPresent()) throw new AdminException("Please Login First");
		return userSession.get();
	}
	@Override
	public Admin logoutAdmin(String key) throws AdminException {
		
        CurrentSession adminSession = csDao.findByUuid(key);
		if(adminSession == null) {
			throw new AdminException("User Not Logged In with this number");
		}
		Optional<Admin> admin=dao.findById(adminSession.getUserId()); 
		csDao.delete(adminSession);
	    if(!admin.isPresent()) throw new AdminException("Register Admin Not found...please Resister");
		return admin.get();
	}

}
