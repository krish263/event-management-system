package com.event.booking.system.project.dao.movies;

import com.event.booking.system.project.entity.movies.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUserName(String userName);
}
