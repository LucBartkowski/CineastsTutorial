package org.neo4j.cineasts.repository;

import org.neo4j.cineasts.domain.Movie;
import org.springframework.data.neo4j.repository.GraphRepository;


public interface MovieRepository extends GraphRepository<Movie> {
  
  Movie findById(String id);
  
}
