package com.graph.service.exceptions;

public class UserNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String userName;
	
	public UserNotFoundException(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String getMessage() {
		return "Usuário " + this.userName + " não encontrado";
	}

}
