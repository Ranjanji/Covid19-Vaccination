package com.covidproof.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	//error current date and tiem
	private LocalDateTime timestamp;
	//Validations message and error messages
	private String message;
	//details of errors
	private String details;
	@Override
	public String toString() {
		return "ErrorDetails [timestamp=" + timestamp + ", message=" + message + ", details=" + details + "]";
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public ErrorDetails(LocalDateTime timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	public ErrorDetails() {
		super();
	}
	
}
