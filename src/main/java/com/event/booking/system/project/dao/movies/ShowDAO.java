package com.event.booking.system.project.dao.movies;

import com.event.booking.system.project.entity.movies.Show;

import java.util.List;

public interface ShowDAO {
    public void addShow(Show sh);

    public List<Show> getShowforGivenMovie(long movieId,long cityId);
}
