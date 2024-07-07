package com.event.booking.system.project.service.movies.impl;

import com.event.booking.system.project.dao.movies.RoleRepository;
import com.event.booking.system.project.dao.movies.UserRepository;
import com.event.booking.system.project.entity.movies.Roles;
import com.event.booking.system.project.entity.movies.User;
import com.event.booking.system.project.exception.movies.exception.DataNotPresent;
import com.event.booking.system.project.service.movies.UserService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder,RoleRepository roleRepository){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
        this.roleRepository=roleRepository;
    }
    @Override
    public void addUser(User u) {
        List<Roles>arr = new ArrayList<>();
        arr.add(this.roleRepository.findByRoleName("ROLE_User"));
        u.setRolesList(arr);
        this.userRepository.save(u);
    }

    @Override
    public User getUserById(long id) {
        Optional<User> u = this.userRepository.findById(id);
        if(u.isEmpty()){
            throw new DataNotPresent("User is not present");
        }
        return u.get();
    }

    @Override
    public User getUserByUsername(String username){
        Optional<User> u = Optional.ofNullable(this.userRepository.findUserByUserName(username));
        if(u.isEmpty()){
            throw new DataNotPresent("User is not present");
        }
        return u.get();
    }

    @Override
    public void saveAll(int cnt) {
        List<User>users = new ArrayList<>();
        String pwd = passwordEncoder.encode("12345");

        for(int i=0;i<cnt;i++){
            Faker faker=new Faker();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = firstName+"."+lastName+"@gmail.com";

            User u = new User(firstName,lastName,email,faker.phoneNumber().cellPhone(),faker.name().username(),pwd);

            List<Roles>arr = new ArrayList<>();
            arr.add(this.roleRepository.findByRoleName("ROLE_User"));
            u.setRolesList(arr);

            users.add(u);
        }
        this.userRepository.saveAll(users);
    }

    @Override
    public Page<User> findAllUsers(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize,Sort.by("firstName"));
        Page<User> userList = userRepository.findAll(pageable);

        return userList;
    }


}
