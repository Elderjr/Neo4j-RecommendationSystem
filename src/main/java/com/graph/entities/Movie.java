package com.graph.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Movie {

	@GeneratedValue
	@Id
	private Long id;
	
	private String name;
	
	private Movie() {
		// Empty constructor required as of Neo4j API 2.0.5
	};
	
	public Movie(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
