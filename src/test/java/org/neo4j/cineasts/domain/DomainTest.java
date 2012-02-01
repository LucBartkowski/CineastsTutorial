package org.neo4j.cineasts.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.cineasts.repository.ActorRepository;
import org.neo4j.cineasts.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/movies-test-context.xml" })
@Transactional
public class DomainTest {

  @Autowired
  Neo4jTemplate template;
  
  @Autowired
  private MovieRepository movieRepository;
  
  @Autowired
  private ActorRepository actorRepository;

  @Test
  @Transactional
  public void persistedMovieShouldBeRetrievableFromGraphDb() {
    Movie forrestGump = movieRepository.save(new Movie("1", "Forrest Gump"));
    Movie retrievedMovie = movieRepository.findById("1");
    assertEquals("retrieved movie matches persisted one", forrestGump, retrievedMovie);
    assertEquals("retrieved movie title matches", "Forrest Gump", retrievedMovie.getTitle());
  }
  
  @Test
  @Transactional
  public void actorCanPlayARoleInAMovie() {
    Actor tomHanks = template.save(new Actor("1", "Tom Hanks"));
    Movie forrestGump = template.save(new Movie("1", "Forrest Gump"));
    Role role = tomHanks.playedIn(forrestGump, "Forrest");
    template.save(role);
    
    Movie foundForestGump = this.movieRepository.findById("1");
    assertEquals("created and looked up movie equal", forrestGump, foundForestGump);
    
    Role firstRole = foundForestGump.getRoles().iterator().next();
    assertEquals("role forrest", role, firstRole);
    assertEquals("role forrest","Forrest", firstRole.getRoleName());
  }

}
