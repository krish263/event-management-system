package com.event.booking.system.project.security.service;

import com.event.booking.system.project.dao.movies.UserRepository;
import com.event.booking.system.project.entity.movies.SecurityUsers;
import com.event.booking.system.project.entity.movies.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> u = Optional.ofNullable(this.userRepository.findUserByUserName(userName));
        if(u.isEmpty()){
            throw  new UsernameNotFoundException("User not found");
        }
        return new SecurityUsers(u.get());
    }
}
