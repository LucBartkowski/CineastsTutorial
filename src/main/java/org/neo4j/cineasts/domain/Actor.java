package org.neo4j.cineasts.domain;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

@NodeEntity
public class Actor {

  @GraphId
  private Long nodeId;

  @Indexed
  String id;

  String name;
 
  @RelatedToVia
  Collection<Role> roles;
  
  public Actor() {
    
  }

  public Actor(String id, String name) {
    super();
    this.id = id;
    this.name = name;
    roles = new HashSet<Role>();
  }
  
  public Iterable<Role> getRoles() {
    return roles;
  }

  public Role playedIn(Movie movie, String roleName) {
    final Role role = new Role(this, movie, roleName);
    roles.add(role);
    return role;
}

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Actor actor = (Actor) o;
    if (nodeId == null)
      return super.equals(o);
    return nodeId.equals(actor.nodeId);

  }

  @Override
  public int hashCode() {
    return nodeId != null ? nodeId.hashCode() : super.hashCode();
  }

}