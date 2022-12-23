package com.covidproof.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobelExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> myHandler2(Exception e,WebRequest w){
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> myHandler3(NoHandlerFoundException e,WebRequest w){
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	//Admin Exception Handler
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<ErrorDetails> myHandler1(AdminException e,WebRequest w){
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	//Vaccine Center Exception Handler
	@ExceptionHandler(VaccineCenterException.class)
	public ResponseEntity<ErrorDetails> myHandler4(VaccineCenterException e,WebRequest w){
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	//VAccine Exception Handler
	@ExceptionHandler(VaccineException.class)
	public ResponseEntity<ErrorDetails> myHandler5(VaccineException e,WebRequest w){
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	//Aadhar Exception Handler
	@ExceptionHandler(AadharException.class)
	public ResponseEntity<ErrorDetails> myHandler5(AadharException e,WebRequest w){
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	//Dose Exception Handler
	@ExceptionHandler(DoseException.class)
	public ResponseEntity<ErrorDetails> myHandler6(DoseException e,WebRequest w){
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	//Applicant Exception Handler
	@ExceptionHandler(ApplicantException.class)
	public ResponseEntity<ErrorDetails> myHandler7(ApplicantException e,WebRequest w){
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(),e.getMessage(),w.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
}
