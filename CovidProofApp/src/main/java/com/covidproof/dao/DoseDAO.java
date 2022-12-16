package com.covidproof.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.covidproof.model.Entity.Dose;
import com.covidproof.model.Entity.VaccineCenter;

public interface DoseDAO extends JpaRepository<Dose, Integer> {
	public List<Dose> findByCenter(VaccineCenter center);
}
