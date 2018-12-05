package com.graph.service.strategies;

import java.util.List;

import com.graph.entities.User;
import com.graph.service.PersonRepository;

public abstract class RelevanceStrategy {
	
	protected abstract List<User> getSelectedUsers(String personName, String movieName, PersonRepository repository);
	
	private float getLikeSimilarity(float similarity, String relationName) {
		if(relationName.equalsIgnoreCase("LIKE")) {
			return similarity;
		}else {
			return 1 - similarity;
		}
	}
	
	public float getRelevance(String personName, String movieName, PersonRepository repository) {
		List<User> users = this.getSelectedUsers(personName, movieName, repository);
		float generalSimilarity = 0;
		int total = 0;
		for(User user : users) {
			String relationName = repository.relationOf(user.getName(), movieName);
			if(relationName != null) {
				float similarity = repository.getSimilarity(personName, user.getName());
				if(similarity != -1) {
					total++;
					generalSimilarity += this.getLikeSimilarity(similarity, relationName);
				}
			}
		}
		generalSimilarity = generalSimilarity / total;
		if(total > 0 && generalSimilarity == 1.0) {
			return (float) 0.99;
		}else if(total > 0 && generalSimilarity == 0) {
			return (float) 0.01;
		}else if(total == 0) {
			return -1;
		}else {
			return generalSimilarity;
		}
	}
}
