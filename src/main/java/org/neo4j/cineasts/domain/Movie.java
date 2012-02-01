package org.neo4j.cineasts.domain;

import static org.neo4j.graphdb.Direction.INCOMING;

import java.util.Collection;

import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

@NodeEntity
public class Movie {

  @GraphId
  private Long nodeId;

  @Indexed
  String id;

  private String title;
  private int year;

  @RelatedToVia(type = "ACTS_IN", direction = INCOMING)
  Iterable<Role> roles;

  public Movie() {
    super();
  }

  public Movie(String id, String title) {
    super();
    this.id = id;
    this.title = title;
  }

  public Long getNodeId() {
    return nodeId;
  }

  public void setNodeId(Long nodeId) {
    this.nodeId = nodeId;
  }

  public String getTitle() {
    return title;
  }

  public Collection<Role> getRoles() {
    return IteratorUtil.asCollection(roles);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Movie movie = (Movie) o;
    if (nodeId == null)
      return super.equals(o);
    return nodeId.equals(movie.nodeId);

  }

  @Override
  public int hashCode() {
    return nodeId != null ? nodeId.hashCode() : super.hashCode();
  }

}