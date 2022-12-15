package com.covidproof.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidproof.dao.VaccineDAO;
import com.covidproof.exception.VaccineException;
import com.covidproof.model.Entity.Vaccine;

@Service
public class VaccineServiceImpl implements VaccineService{
	@Autowired
	private VaccineDAO vaccineDao;

	@Override
	public Vaccine addVaccine(Vaccine vaccine) throws VaccineException {
		Vaccine v=vaccineDao.save(vaccine);
		if(v==null) throw new VaccineException("Vaccine not found");
		return v;
	}

	@Override
	public Vaccine updateVaccine(Vaccine vaccine) throws VaccineException {
	    Optional<Vaccine> opt=vaccineDao.findById(vaccine.getVaccineId());
	    
	    if(opt.isPresent()) {
	    	Vaccine v=vaccineDao.save(vaccine);
	    	return v;
	    }
	    else throw new VaccineException("Vaccine not found");
	    
	}

	@Override
	public Vaccine deleteVaccine(Integer vaccineId) throws VaccineException {
		Optional<Vaccine> opt = vaccineDao.findById(vaccineId);

		if (opt.isPresent()) {

			Vaccine existingVaccine = opt.get();

			vaccineDao.delete(existingVaccine);

			return existingVaccine;

		} 
			else throw new VaccineException("Vaccine not found with vaccine id :" + vaccineId);
	}

	@Override
	public Vaccine getVaccineById(Integer vaccineId) throws VaccineException {
		Optional<Vaccine> opt = vaccineDao.findById(vaccineId);

		if (opt.isPresent()) {

			Vaccine existingVaccine = opt.get();
			return existingVaccine;

		} 
			else throw new VaccineException("Vaccine not found with vaccine id :" + vaccineId);
	}

	@Override
	public List<Vaccine> getAllVaccine() throws VaccineException {
		List<Vaccine> vaccList= vaccineDao.findAll();
		if(vaccList.isEmpty()) throw new VaccineException("Vaccines not found Please Add Vaccine Details");
		else return vaccList;
	}

}
