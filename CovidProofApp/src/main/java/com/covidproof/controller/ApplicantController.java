package com.covidproof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covidproof.service.ApplicantService;

@RestController
@RequestMapping("/user")
public class ApplicantController {
	@Autowired
	private ApplicantService service;
	
}
