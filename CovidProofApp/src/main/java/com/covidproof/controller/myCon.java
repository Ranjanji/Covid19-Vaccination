package com.covidproof.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.covidproof.model.Entity.Admin;
import com.covidproof.service.testImpl;

@RestController
public class myCon {
	@Autowired
	private testImpl service;
	
	@PostMapping("/fjdlfjkl")
	public String addAdmin(@RequestBody Admin a) {
		return service.saveAd(a);
	}
}
