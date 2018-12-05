package com.graph.service;


import org.springframework.data.repository.CrudRepository;
import com.graph.entities.Movie;


public interface MovieRepository extends CrudRepository<Movie, Long> {

	public Movie findByName(String name);

}
