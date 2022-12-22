package com.covidproof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.covidproof.service.VaccineCenterService;

@RestController
public class VaccineCenterController {
	@Autowired
	private VaccineCenterService vcService;
	
	//get vaccine center id by vaccine center name
	@GetMapping("/getVaccCentId/{vcname}")
	public ResponseEntity<Integer> getIdByName(@PathVariable("vcname") String name){
		Integer id = vcService.getVCIdByName(name);
		return new ResponseEntity<Integer>(id,HttpStatus.OK);
	}
}
