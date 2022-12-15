package com.covidproof.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.covidproof.model.Entity.Admin;
//Admin can add,Delete,update,view,viewAll  Vaccine,VaccineCenter
//Admin can view,update IdCard Details
@Repository
public interface AdminDAO extends JpaRepository<Admin, Integer> {
	@Query("select a from Admin a where a.mobile=?1 and a.password=?2 ")
	public Admin loginAdmin(String mobile,String password);
	
}
