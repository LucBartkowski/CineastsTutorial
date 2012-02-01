package org.neo4j.cineasts.controller;

import java.util.Collection;

import org.neo4j.cineasts.domain.Movie;
import org.neo4j.cineasts.service.DatabasePopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MovieController {
  
  @Autowired private DatabasePopulator populator;
  
  @RequestMapping(value = "populate", method = RequestMethod.POST)
  public String populateDatabase(Model model) {
    Collection<Movie> movies = populator.populateDatabase();
    model.addAttribute("movies", movies);
    
    return "/movies/list";
  }

}
