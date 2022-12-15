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

import com.covidproof.model.DTO.AdminDTO;
import com.covidproof.model.Entity.Admin;
import com.covidproof.model.Entity.IdCard;
import com.covidproof.model.Entity.Vaccine;
import com.covidproof.model.Entity.VaccineCenter;
import com.covidproof.model.NonEntity.AdminLogin;
import com.covidproof.service.AdminService;
import com.covidproof.service.ApplicantService;
import com.covidproof.service.VaccineCenterService;
import com.covidproof.service.VaccineService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService service;
	
	@Autowired
	private VaccineService vService;
	
	@Autowired
	private VaccineCenterService vcService;
	
	@Autowired 
	private ApplicantService apService;
	
	@GetMapping("/login")
	public ResponseEntity<Admin> loginAdmin(@RequestBody AdminLogin al){
		return new ResponseEntity<>(service.loginAdmin(al.getMobile(),al.getPassword()), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Admin> registerAdmin(@RequestBody Admin a){
		return new ResponseEntity<Admin>(service.registerAdmin(a),HttpStatus.ACCEPTED);
	}
	@PutMapping("/update")
	public ResponseEntity<Admin> updatePassword(@RequestBody AdminDTO admindto){
		return new ResponseEntity<Admin>(service.updatePassword(admindto.getMobile(), admindto.getOld_pass(), admindto.getNew_pass()),HttpStatus.ACCEPTED);
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
	public ResponseEntity<Vaccine> addVaccine(@RequestBody AdminLogin al,@PathVariable("n")String name,@PathVariable("d")String des){
		service.loginAdmin(al.getMobile(),al.getPassword() );
		Vaccine vaccine=new Vaccine();
		vaccine.setDescription(des);
		vaccine.setName(name);
		return new ResponseEntity<Vaccine>(vService.addVaccine(vaccine),HttpStatus.ACCEPTED);
	}
	@PostMapping("/vaccinecenter/{name}/{address}/{city}/{state}/{pin}")
	public ResponseEntity<VaccineCenter> addVaccineCenter(@RequestBody AdminLogin al,@PathVariable("name")String name,@PathVariable("address")String address,@PathVariable("city")String city,@PathVariable("state")String state,@PathVariable("pin")String pin){
		service.loginAdmin(al.getMobile(),al.getPassword() );
		VaccineCenter vc=new VaccineCenter();
		vc.setAddress(address);
		vc.setCenterName(name);
		vc.setCity(city);
		vc.setState(state);
		return new ResponseEntity<>(vcService.addVaccineCenter(vc),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/vaccine/{id}")
	public ResponseEntity<Vaccine> deleteVaccine(@RequestBody AdminLogin al,@PathVariable("id")Integer id){
		service.loginAdmin(al.getMobile(),al.getPassword() );
		return new ResponseEntity<Vaccine>(vService.deleteVaccine(id),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/vaccinecenter/{id}")
	public ResponseEntity<VaccineCenter> deleteVaccineCenter(@RequestBody AdminLogin al,@PathVariable("id")Integer id){
		service.loginAdmin(al.getMobile(),al.getPassword() );
		return new ResponseEntity<>(vcService.deleteVaccineCenter(id),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/idcards")
	public ResponseEntity<List<IdCard>> getAllCards(){
		return new ResponseEntity<List<IdCard>>(apService.getAllIdCards(),HttpStatus.FOUND);
	}
	@DeleteMapping("/idcard/{id}")
	public ResponseEntity<Boolean> deleteCard(@RequestBody AdminLogin al,@PathVariable("id")Integer id){
		service.loginAdmin(al.getMobile(),al.getPassword() );
		return new ResponseEntity<>(apService.deleteCard(id),HttpStatus.FOUND);
	}
}
