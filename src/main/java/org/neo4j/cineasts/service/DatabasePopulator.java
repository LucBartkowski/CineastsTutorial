package org.neo4j.cineasts.service;

import static java.util.Arrays.asList;

import java.util.List;

import org.neo4j.cineasts.domain.Actor;
import org.neo4j.cineasts.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DatabasePopulator {

  @Autowired
  Neo4jTemplate template;
  
  @Transactional
  public List<Movie> populateDatabase() {
    Actor tomHanks = new Actor("1", "Tom Hanks");
    Movie forrestGump = new Movie("1", "Forrest Gump");
    tomHanks.playedIn(forrestGump, "Forrest");
    template.save(forrestGump);
    return asList(forrestGump);
  }
}
