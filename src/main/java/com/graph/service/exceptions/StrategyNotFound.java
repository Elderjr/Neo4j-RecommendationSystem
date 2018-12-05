package com.graph.service.exceptions;

public class StrategyNotFound extends Exception{

	private static final long serialVersionUID = 1L;
	private String strategyName;
	
	public StrategyNotFound(String strategyName) {
		this.strategyName = strategyName;
	}
	
	@Override
	public String getMessage() {
		return "Estratégia " + this.strategyName + " não encontrada";
	}
}
