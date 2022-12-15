package com.covidproof.dao;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.covidproof.model.Entity.IdCard;
@Repository
public interface ApplicantDAO extends JpaRepository<IdCard, Integer> {

	// finding an applicant by mobile number and dob
	@Query("select i from IdCard i where i.mobile=?1 AND i.dob=?2")
	public IdCard findByMobAndDob(String mobile, LocalDate dob);
	
	// getting applicant by mobile number
	public IdCard findByMobile(String mobile);
	
	
}
