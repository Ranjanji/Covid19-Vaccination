package com.covidproof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.covidproof.model.Entity.AadharCard;
import com.covidproof.model.Entity.Admin;
import com.covidproof.model.Entity.Appointment;
import com.covidproof.model.Entity.Dose;
import com.covidproof.model.Entity.IdCard;
import com.covidproof.model.NonEntity.ApplicantLogin;
import com.covidproof.service.AadharcardService;
import com.covidproof.service.ApplicantService;
import com.covidproof.service.VaccineCenterService;
import com.covidproof.service.VaccineService;

@RestController
@RequestMapping("/user")
public class ApplicantController {
	
	@Autowired
	private ApplicantService service;
	
	@Autowired
	private VaccineService vService;
	
	@Autowired
	private VaccineCenterService vcService;
	
	@Autowired
	private AadharcardService acService;
	
	@GetMapping("/login")
	public ResponseEntity<IdCard> loginAdmin(@RequestBody ApplicantLogin al){
		return new ResponseEntity<>(service.loginApplicant(al.getMobile(), al.getDob()), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/register/{adno}")
	public ResponseEntity<IdCard> registerApplicant(@RequestBody IdCard card,@PathVariable("adno")Integer adno){
		
		return new ResponseEntity<>(service.registerAnApplicant(card, adno),HttpStatus.ACCEPTED);
	}
	@PostMapping("/vaccination/{id}/{vid}/{vcid}/{dose}")
	public ResponseEntity<Dose> applyForVaccination(@RequestBody Appointment appointment,@PathVariable("id")Integer id,@PathVariable("vid")Integer vid,@PathVariable("vcid")Integer vcid,@PathVariable("dose")Integer dose){
		
		return new ResponseEntity<>(service.applyForVaccination(id,vid, vcid, dose, appointment),HttpStatus.ACCEPTED);
	}
	
	
}
