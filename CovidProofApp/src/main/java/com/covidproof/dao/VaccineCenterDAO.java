package com.covidproof.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.covidproof.exception.VaccineCenterException;
import com.covidproof.model.Entity.VaccineCenter;

@Repository
public interface VaccineCenterDAO extends JpaRepository<VaccineCenter, Integer> {
	//get Vaccine center list list by center name
	public List<VaccineCenter> getVaccineCenterByCenterName(String centerName) throws VaccineCenterException;
	//get vaccine center id by center name
	@Query("select vc.centerCode from VaccineCenter vc where vc.centerName=?1")
	public Integer getIdByName(String name);
}
