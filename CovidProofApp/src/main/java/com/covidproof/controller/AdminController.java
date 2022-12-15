package com.covidproof.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covidproof.model.Entity.Admin;
import com.covidproof.model.NonEntity.AdminLogin;
import com.covidproof.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService service;
	
	@GetMapping("/login")
	public ResponseEntity<Admin> loginAdmin(@RequestBody AdminLogin al){
		return new ResponseEntity<>(service.loginAdmin(al.getMobile(),al.getPassword()), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Admin> registerAdmin(@RequestBody Admin a){
		return new ResponseEntity<Admin>(service.registerAdmin(a),HttpStatus.ACCEPTED);
	}
	
}
