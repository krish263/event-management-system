package com.event.booking.system.project.service.movies;

import com.event.booking.system.project.entity.movies.Hall;
import com.event.booking.system.project.entity.movies.Theater;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public interface TheaterService {
    public void add(Theater theater);
    public List<Theater> get();

    public List<Theater>getByCityName(String city);

    public void addHall(Hall hall);

    public List<Hall>getHalls(long id);

    public void addDummyTheater(int cnt);

    public void addDummyHalls(int cnt);

    public Theater getById(long id);
}
