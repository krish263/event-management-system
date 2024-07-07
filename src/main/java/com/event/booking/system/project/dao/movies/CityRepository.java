package com.event.booking.system.project.dao.movies;

import com.event.booking.system.project.entity.movies.City;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CityRepository extends JpaRepository<City,Long> {
//    public void saveCity(City city);
//    public City getCityById(long id);
    City findByCityName(String cityName);
}
