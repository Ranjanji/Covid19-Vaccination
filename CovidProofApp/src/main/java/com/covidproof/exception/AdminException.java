package com.covidproof.exception;

public class AdminException extends RuntimeException{
	public AdminException() {}
	public AdminException(String m) {
		super(m);
	}
}
