package com.event.booking.system.project.dao.movies;

import com.event.booking.system.project.entity.movies.Celebrity;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface CelebrityRepository extends JpaRepository<Celebrity,Long> {

    Celebrity getCelebrityById(long id);

}
