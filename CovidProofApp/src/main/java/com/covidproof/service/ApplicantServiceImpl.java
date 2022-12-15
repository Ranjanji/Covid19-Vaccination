package com.covidproof.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidproof.dao.ApplicantDAO;

@Service
public class ApplicantServiceImpl implements ApplicantService {
	@Autowired
	private ApplicantDAO dao;
}
