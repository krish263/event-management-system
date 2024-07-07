package com.event.booking.system.project.service.movies;

import com.event.booking.system.project.entity.movies.Show;
import jakarta.transaction.Transactional;

@Transactional
public interface ShowService {
    public void addShow(Show sh);
}
