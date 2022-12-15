package com.covidproof.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covidproof.exception.VaccineCenterException;
import com.covidproof.model.Entity.VaccineCenter;

@Repository
public interface VaccineCenterDAO extends JpaRepository<VaccineCenter, Integer> {
	public List<VaccineCenter> getVaccineCenterByCenterName(String centerName) throws VaccineCenterException;
}
