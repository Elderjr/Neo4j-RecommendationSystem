package com.graph.entities;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class User {

	@GeneratedValue
	@Id
	private Long id;

	private String name;

	@Relationship(type="FRIEND_OF", direction=Relationship.UNDIRECTED)
	private List<User> friends;
	
	@Relationship(type="LIKE", direction=Relationship.OUTGOING)
	private List<Movie> likes;
	
	@Relationship(type="DISLIKE", direction=Relationship.OUTGOING)
	private List<Movie> dislikes;
	
	private User() {
		// Empty constructor required as of Neo4j API 2.0.5
	};

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public List<User> getFriends() {
		return this.friends;
	}
	
	public List<Movie> getLikes() {
		return this.likes;
	}
	
	public List<Movie> getDislikes() {
		return this.likes;
	}
}