package com.event.booking.system.project.service.movies;

import com.event.booking.system.project.entity.movies.Movie;
import jakarta.transaction.Transactional;

@Transactional
public interface MoviesService {
    public void addMovie(Movie m);
    public Movie getMovie(long id);
}
