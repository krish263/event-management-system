package com.event.booking.system.project.service.movies;

import com.event.booking.system.project.entity.movies.Celebrity;
import jakarta.transaction.Transactional;

@Transactional
public interface CelebrityService {
    public void addCelebrity(Celebrity celebrity);
    public Celebrity getCelebrity(long id);
}
