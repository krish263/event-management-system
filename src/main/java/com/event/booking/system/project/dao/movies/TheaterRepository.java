package com.event.booking.system.project.dao.movies;

import com.event.booking.system.project.entity.movies.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TheaterRepository extends JpaRepository<Theater,Long> {

    @Query("SELECT t FROM Theater t WHERE t.city.cityName = :cityName")
    List<Theater> fetchByCityName(@Param("cityName") String cityName);
}
