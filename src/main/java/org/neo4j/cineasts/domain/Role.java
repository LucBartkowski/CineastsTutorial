package org.neo4j.cineasts.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;

@RelationshipEntity
public class Role {
	@GraphId Long id;
	Movie movie;
	Actor actor;
    String role;
}