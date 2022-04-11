package com.bhatta.management.response;

public class ResponseObject<T> {
	private Status status;
	private T response;
	
	
	public ResponseObject(Status status, T response) {
		super();
		this.status = status;
		this.response = response;
	}
	
	
	public ResponseObject() {
		super();
	}

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	
	
}
