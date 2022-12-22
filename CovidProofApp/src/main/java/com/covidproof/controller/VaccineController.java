package com.covidproof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.covidproof.service.VaccineService;

@RestController
public class VaccineController {
	@Autowired
	private VaccineService vService;
	
	//get vaccine id by vaccine center name
	@GetMapping("/getVaccId/{vname}")
	public ResponseEntity<Integer> getIdByName(@PathVariable("vname") String name){
		Integer id = vService.getIdByName(name);
		return new ResponseEntity<Integer>(id,HttpStatus.OK);
	}
}
