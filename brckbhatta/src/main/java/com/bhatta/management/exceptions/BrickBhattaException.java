package com.bhatta.management.exceptions;

public class BrickBhattaException extends Exception{
	private static final long serialVersionUID= 1L;
	
	public BrickBhattaException(String message) {
		super(message);
	}
	
	public BrickBhattaException(Throwable cause) {
		super(cause);
	}
	
	public BrickBhattaException(String message,Throwable cause) {
		super(message,cause);
	}
}
