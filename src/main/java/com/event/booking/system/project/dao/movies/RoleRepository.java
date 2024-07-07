package com.event.booking.system.project.dao.movies;

import com.event.booking.system.project.entity.movies.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles,Long> {

    Roles findByRoleName(String roleName);
}
