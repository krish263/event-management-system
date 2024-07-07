package com.event.booking.system.project.controller.movies;

import com.event.booking.system.project.entity.movies.Movie;
import com.event.booking.system.project.service.movies.MoviesService;
import com.event.booking.system.project.service.movies.impl.MoviesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MoviesService moviesServiceImpl;

    @Autowired
    public MovieController(MoviesServiceImpl moviesServiceImpl){
        this.moviesServiceImpl = moviesServiceImpl;
    }

    @PostMapping
    public void addMovie(@RequestBody Movie movie){
        moviesServiceImpl.addMovie(movie);
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable long id){
        return moviesServiceImpl.getMovie(id);
    }
}
