package com.graph.service;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.CrudRepository;

import com.graph.entities.Movie;
import com.graph.entities.User;

public interface PersonRepository extends CrudRepository<User, Long> {

	@Query(value = "Match (p1:User{name:{0}}) - [r1] -> (m:Movie) <- [r2] - (p2:User{name:{1}})"
			+ " with r1,r2, CASE when (type(r1) = type(r2)) THEN 1 ELSE 0 END as commons"
			+ " return CASE when count(commons) > 0 THEN toFloat(sum(commons)) / count(commons) ELSE -1 END as similarity")
	public Float getSimilarity(String person1, String person2);

	@Query(value = "MATCH (s:User { name:{0} }),(e:Movie { name:{1} }), p = allShortestPaths((s)-[*]-(e))" + 
			" WHERE NONE(x IN nodes(p) WHERE x <> e AND 'Movie' IN labels(x))" + 
			" return nodes(p)[length(p) - 1]")
	public List<User> shortestPathFriends(String person, String movieName);
			
	@Query(value = "Match (:User{name: {0}}) - [:FRIEND_OF] - (friends) - [] -> (:Movie{name:{1}}) return friends")
	public List<User> friendsOf(String person, String movieName);

	@Query(value = "Match (u:User) - [] -> (:Movie{name:{1}}) where u.name <> {0} return u")
	public List<User> allUsers(String person, String movieName);
	
	@Query(value = "match (:User{name: {0}}) - [r] - (:Movie{name: {1}}) return type(r)")
	public String relationOf(String personName, String movieName);

	@Query(value = "MATCH (m:Movie) WHERE NOT (:User{name:{0}})-[]->(m) RETURN m")
	public List<Movie> unseenMovies(String personName);
	
	public User findByName(String name);

}
