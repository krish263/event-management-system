package com.event.booking.system.project.service.movies.impl;

import com.event.booking.system.project.dao.movies.MoviesRepository;
import com.event.booking.system.project.entity.movies.Movie;
import com.event.booking.system.project.exception.movies.exception.DataNotBeCreated;
import com.event.booking.system.project.exception.movies.exception.DataNotPresent;
import com.event.booking.system.project.service.movies.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MoviesServiceImpl implements MoviesService {

    private final MoviesRepository moviesRepository;

    @Autowired
    public MoviesServiceImpl(MoviesRepository moviesRepository){
        this.moviesRepository=moviesRepository;
    }

    @Override
    public void addMovie(Movie m){
        try{
            moviesRepository.save(m);
        }
        catch(Exception e){
            throw new DataNotBeCreated("Error while creating movie");
        }
    }

    @Override
    public Movie getMovie(long id){
        Optional<Movie>movie = Optional.ofNullable(moviesRepository.getMovieById(id));

        if(movie.isEmpty()){
            throw new DataNotPresent("No such movie is present");
        }

        return movie.get();
    }
}
