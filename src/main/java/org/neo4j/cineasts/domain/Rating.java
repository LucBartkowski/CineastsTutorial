package org.neo4j.cineasts.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;

@RelationshipEntity
public class Rating {
	@GraphId Long id;
	User user;
	Movie movie;
	int stars;
	String comment;
}