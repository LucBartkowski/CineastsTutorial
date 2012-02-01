package org.neo4j.cineasts.domain;

import java.util.Set;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Movie {

	@GraphId
	private Long nodeId;
	private String title;
	private int year;
	private Set<Role> cast;

	public Movie() {
		super();
	}

	public Movie(String title, int year) {
		this.title = title;
		this.year = year;
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

	private Set<Role> getCast() {
		return cast;
	}

	private void setCast(Set<Role> cast) {
		this.cast = cast;
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