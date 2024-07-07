package com.event.booking.system.project.service.movies;

import com.event.booking.system.project.entity.movies.City;
import jakarta.transaction.Transactional;

@Transactional
public interface CityService {
    public void addCity(City city);

    public City getCity(long id);

    public City getCityByName(String name);

    public City getTheaterList(long id);
}
