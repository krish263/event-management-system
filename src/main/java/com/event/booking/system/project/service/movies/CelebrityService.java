package com.event.booking.system.project.service.movies;

import com.event.booking.system.project.entity.movies.Celebrity;
import jakarta.transaction.Transactional;

//for branch sf2
//21
//22
//23
//24

@Transactional
public interface CelebrityService {
    public void addCelebrity(Celebrity celebrity);
    public Celebrity getCelebrity(long id);
}
