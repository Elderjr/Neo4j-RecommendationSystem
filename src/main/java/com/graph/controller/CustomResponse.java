package com.graph.controller;


public class CustomResponse {

	
	private int httpCode;
	private boolean status;
	private String message;
	private Long time;
	private Object result;
	
	public CustomResponse(Object result, String message, boolean status, int httpCode, Long time) {
		this.result = result;
		this.status = status;
		this.httpCode = httpCode;
		this.time = time;
		this.message = message;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public boolean isStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public Long getTime() {
		return time;
	}

	public Object getResult() {
		return result;
	}
}
