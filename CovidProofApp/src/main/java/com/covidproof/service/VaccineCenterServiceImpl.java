package com.covidproof.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidproof.dao.VaccineCenterDAO;
import com.covidproof.exception.VaccineCenterException;
import com.covidproof.model.Entity.VaccineCenter;


@Service
public class VaccineCenterServiceImpl implements VaccineCenterService{
	@Autowired
	private VaccineCenterDAO vaccineCenterDao;

	@Override
	public VaccineCenter addVaccineCenter(VaccineCenter vCenter) throws VaccineCenterException {
		VaccineCenter vc=vaccineCenterDao.save(vCenter);
		if(vc==null) throw new VaccineCenterException("VaccineCenter not found");
		return vc;
	}

	@Override
	public VaccineCenter updateVaccineCenter(VaccineCenter vCenter) throws VaccineCenterException {
	    Optional<VaccineCenter> opt=vaccineCenterDao.findById(vCenter.getCenterCode());
	    
	    if(opt.isPresent()) {
	    	VaccineCenter vc=vaccineCenterDao.save(vCenter);
	    	return vc;
	    }
	    else throw new VaccineCenterException("VaccineCenter not found");
	    
	}

	@Override
	public VaccineCenter deleteVaccineCenter(Integer centerCode) throws VaccineCenterException {
		Optional<VaccineCenter> opt = vaccineCenterDao.findById(centerCode);

		if (opt.isPresent()) {

			VaccineCenter existingVaccineCenter = opt.get();

			vaccineCenterDao.delete(existingVaccineCenter);

			return existingVaccineCenter;

		} 
			else throw new VaccineCenterException("Vaccine Center not found with vaccineCenter code:" + centerCode);
	}

	@Override
	public VaccineCenter getVaccineById(Integer centerCode) throws VaccineCenterException {
		Optional<VaccineCenter> opt = vaccineCenterDao.findById(centerCode);

		if (opt.isPresent()) {

			VaccineCenter existingVaccineCenter = opt.get();
			return existingVaccineCenter;

		} 
			else throw new VaccineCenterException("Vaccine Center not found with vaccine Center code :" + centerCode);
	}

	@Override
	public List<VaccineCenter> getAllVaccineCenter() throws VaccineCenterException {
		List<VaccineCenter> vCenterList= vaccineCenterDao.findAll();
		if(vCenterList.isEmpty()) throw new VaccineCenterException("Vaccine Center's not found Please Add Vaccine Center Details");
		else return vCenterList;
	}

	@Override
	public Integer getVCIdByName(String name) throws VaccineCenterException {
		int id = vaccineCenterDao.getIdByName(name);
		if(id!=0) {
			return id;
		}
		else {
			throw new VaccineCenterException("No vaccine center exist with name:"+name);
		}
	}

}
