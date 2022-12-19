package com.covidproof.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.covidproof.exception.VaccineException;
import com.covidproof.model.Entity.Vaccine;

@Repository
public interface VaccineDAO extends JpaRepository<Vaccine, Integer> {
	public List<Vaccine> getVaccineByName(String name) throws VaccineException;
	@Query("select v.vaccineId from Vaccine v where v.name=?1")
	public Integer getIdByName(String name);
}
