package org.neo4j.cineasts.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/movies-test-context.xml"})
@Transactional
public class DomainTest {
	
	@Autowired Neo4jTemplate template;
	
	@Test @Transactional public void persistedMovieShouldBeRetrievableFromGraphDb() {
		Movie forrestGump = template.save(new Movie("Forrest Gump", 1994));
		Movie retrievedMovie = template.findOne(forrestGump.getNodeId(), Movie.class);
		assertEquals("retrieved movie matches persisted one", forrestGump, retrievedMovie);
		assertEquals("retrieved movie title matches", "Forrest Gump", retrievedMovie.getTitle());
	}
}

