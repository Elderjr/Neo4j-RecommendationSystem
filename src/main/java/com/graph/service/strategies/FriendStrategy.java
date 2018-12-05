package com.graph.service.strategies;

import java.util.List;

import com.graph.entities.User;
import com.graph.service.PersonRepository;

public class FriendStrategy extends RelevanceStrategy{

	@Override
	protected List<User> getSelectedUsers(String personName, String movieName, PersonRepository repository) {
		return repository.friendsOf(personName, movieName);
	}

}
