package com.event.booking.system.project.dao.movies;

import com.event.booking.system.project.entity.movies.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface MoviesRepository extends JpaRepository<Movie,Long> {

    Movie getMovieById(long id);
}
