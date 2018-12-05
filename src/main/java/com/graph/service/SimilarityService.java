package com.graph.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.graph.service.exceptions.MovieNotFoundException;
import com.graph.service.exceptions.StrategyNotFound;
import com.graph.service.exceptions.UserNotFoundException;
import com.graph.service.strategies.RelevanceFactory;
import com.graph.service.strategies.RelevanceStrategy;

@Service
public class SimilarityService {

	@Autowired
	private PersonRepository userRepository;

	@Autowired
	private MovieRepository movieRepository;
	
	public float getRelevance(String personName, String movieName, String strategyName)
			throws UserNotFoundException, MovieNotFoundException, StrategyNotFound {
		RelevanceStrategy strategy = RelevanceFactory.createStrategy(strategyName);
		if (strategy == null) {
			throw new StrategyNotFound(strategyName);
		}else if(this.userRepository.findByName(personName) == null) {
			throw new UserNotFoundException(personName);
		}else if(this.movieRepository.findByName(movieName) == null) {
			throw new MovieNotFoundException(movieName);
		}
		return strategy.getRelevance(personName, movieName, this.userRepository);
	}
}
