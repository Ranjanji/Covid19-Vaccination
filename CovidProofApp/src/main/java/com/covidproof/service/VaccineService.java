package com.covidproof.service;

import java.util.List;

import com.covidproof.exception.VaccineException;
import com.covidproof.model.Entity.Vaccine;

public interface VaccineService {
	public Vaccine addVaccine(Vaccine vaccine) throws VaccineException;
    public Vaccine updateVaccine(Vaccine vaccine) throws VaccineException;
    public Vaccine getVaccineById(Integer vaccineId) throws VaccineException;
    public Vaccine deleteVaccine(Integer vaccineId) throws VaccineException;
    public List<Vaccine> getAllVaccine() throws VaccineException;
	public Integer getIdByName(String name);
}
