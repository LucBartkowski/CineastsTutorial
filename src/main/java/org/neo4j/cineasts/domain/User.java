package org.neo4j.cineasts.domain;

import java.util.Set;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class User {
	@GraphId Long nodeId;
	String login;
	String name;
	String password;
	Set<Rating> ratings;
	Set<User> friends;

	public Rating rate(Movie movie, int stars, String comment) {
		return null;
	}
	
	public void befriend(User user) { }
}