package com.covidproof.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covidproof.model.DTO.AdminLoginDTO;
import com.covidproof.model.DTO.AdminPasswordDTO;
import com.covidproof.model.Entity.Admin;
import com.covidproof.model.Entity.IdCard;
import com.covidproof.model.Entity.Vaccine;
import com.covidproof.model.Entity.VaccineCenter;
import com.covidproof.service.AdminService;
import com.covidproof.service.ApplicantService;
import com.covidproof.service.VaccineCenterService;
import com.covidproof.service.VaccineService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService aservice;
	
	@Autowired
	private VaccineService vService;
	
	@Autowired
	private VaccineCenterService vcService;
	
	@Autowired 
	private ApplicantService apService;
	
	@PostMapping("/login")
	public ResponseEntity<Admin> loginAdmin(@RequestBody AdminLoginDTO aLoginDto){
		return new ResponseEntity<>(aservice.loginAdmin(aLoginDto), HttpStatus.ACCEPTED);
	}
	@PostMapping("/logout")
	public ResponseEntity<Admin> logoutAdmin(@RequestBody String mobile){
		return new ResponseEntity<>(aservice.logoutAdmin(aservice.adminSession(mobile).getUuid()), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Admin> registerAdmin(@RequestBody Admin a){
		return new ResponseEntity<Admin>(aservice.registerAdmin(a),HttpStatus.ACCEPTED);
	}
	@PutMapping("/update")
	public ResponseEntity<Admin> updatePassword(@RequestBody AdminPasswordDTO aPassDto){
		return new ResponseEntity<Admin>(aservice.updatePassword(aPassDto),HttpStatus.ACCEPTED);
	}
	@GetMapping("/vaccine")
	public ResponseEntity<List<Vaccine>> getAllVaccine(){
		return new ResponseEntity<List<Vaccine>>(vService.getAllVaccine(),HttpStatus.FOUND);
	}
	@GetMapping("/vaccinecenter")
	public ResponseEntity<List<VaccineCenter>> getAllVaccineCenter(){
		return new ResponseEntity<List<VaccineCenter>>(vcService.getAllVaccineCenter(),HttpStatus.FOUND);
	}
	@PostMapping("/vaccine/{n}/{d}")
	public ResponseEntity<Vaccine> addVaccine(@RequestBody String mobile,@PathVariable("n")String name,@PathVariable("d")String des){
		    aservice.adminSession(mobile);
			Vaccine vaccine=new Vaccine();
			vaccine.setDescription(des);
			vaccine.setName(name);
			return new ResponseEntity<Vaccine>(vService.addVaccine(vaccine),HttpStatus.ACCEPTED);
	}
	@PostMapping("/vaccinecenter/{name}/{address}/{city}/{state}/{pin}")
	public ResponseEntity<VaccineCenter> addVaccineCenter(@RequestBody String mobile,@PathVariable("name")String name,@PathVariable("address")String address,@PathVariable("city")String city,@PathVariable("state")String state,@PathVariable("pin")String pin){
		aservice.adminSession(mobile);
		VaccineCenter vc=new VaccineCenter();
		vc.setAddress(address);
		vc.setCenterName(name);
		vc.setCity(city);
		vc.setState(state);
		return new ResponseEntity<>(vcService.addVaccineCenter(vc),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/vaccine/{id}")
	public ResponseEntity<Vaccine> deleteVaccine(@RequestBody String mobile,@PathVariable("id")Integer id){
		aservice.adminSession(mobile);
		return new ResponseEntity<Vaccine>(vService.deleteVaccine(id),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/vaccinecenter/{id}")
	public ResponseEntity<VaccineCenter> deleteVaccineCenter(@RequestBody String mobile,@PathVariable("id")Integer id){
		aservice.adminSession(mobile);
		return new ResponseEntity<>(vcService.deleteVaccineCenter(id),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/idcards")
	public ResponseEntity<List<IdCard>> getAllCards(){
		return new ResponseEntity<List<IdCard>>(apService.getAllIdCards(),HttpStatus.FOUND);
	}
	@DeleteMapping("/idcard/{id}")
	public ResponseEntity<Boolean> deleteCard(@RequestBody String mobile,@PathVariable("id")Integer id){
		aservice.adminSession(mobile);
		return new ResponseEntity<>(apService.deleteCard(id),HttpStatus.FOUND);
	}
}
