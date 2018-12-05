package com.graph.service.exceptions;

public class MovieNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	private String movieName;
	
	public MovieNotFoundException(String movieName) {
		this.movieName = movieName;
	}
	
	@Override
	public String getMessage() {
		return "Filme " + this.movieName + " não encontrado";
	}
}
