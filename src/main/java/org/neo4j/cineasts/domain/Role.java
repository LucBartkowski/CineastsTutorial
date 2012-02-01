package org.neo4j.cineasts.domain;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type="ACTS_IN")
public class Role {
  
  @GraphId
  Long id;

	@StartNode
	Actor actor;
	
	@EndNode
	Movie movie;
	
  private String roleName;
  
  public Role() {
    
  }
  
  public Role(Actor actor, Movie movie, String roleName) {
    super();
    this.actor = actor;
    this.movie = movie;
    this.setRoleName(roleName);
  }

  String getRoleName() {
    return roleName;
  }

  void setRoleName(String roleName) {
    this.roleName = roleName;
  }
  
  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Role role = (Role) o;
      if (id == null) return super.equals(o);
      return id.equals(role.id);

  }

  @Override
  public int hashCode() {
      return id != null ? id.hashCode() : super.hashCode();
  }

}