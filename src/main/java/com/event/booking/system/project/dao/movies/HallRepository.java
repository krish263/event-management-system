package com.event.booking.system.project.dao.movies;

import com.event.booking.system.project.entity.movies.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HallRepository extends JpaRepository<Hall,Long> {

    @Query("Select h from Hall h Where h.theater.id = :id")
    public List<Hall> findHallByID(@Param("id") long id);
}
