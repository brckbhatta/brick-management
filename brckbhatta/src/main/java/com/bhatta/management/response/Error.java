package com.bhatta.management.response;

public class Error {
	private String identifier;
	private String message;
	
	
	public Error(String identifier, String message) {
		super();
		this.identifier = identifier;
		this.message = message;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
