package org.neo4j.cineasts.domain;

import java.util.Set;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Actor {
	@GraphId Long nodeId;
    String name;
    Set<Movie> filmography;
    
	public Role playedIn(Movie movie, String role) {
	 	return null;
	}
}