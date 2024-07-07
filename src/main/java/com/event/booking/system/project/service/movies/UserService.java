package com.event.booking.system.project.service.movies;

import com.event.booking.system.project.entity.movies.User;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;

import java.util.List;

@Transactional
public interface UserService {
    public void addUser(User u);
    public User getUserById(long id);
    public User getUserByUsername(String username);

    public void saveAll(int cnt);

    public Page<User> findAllUsers(int pageNo, int totalPages);
}
