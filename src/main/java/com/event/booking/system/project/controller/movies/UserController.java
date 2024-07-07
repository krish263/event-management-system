package com.event.booking.system.project.controller.movies;

import com.event.booking.system.project.entity.movies.User;
import com.event.booking.system.project.events.PaginatedResultsRetrievedEvent;
import com.event.booking.system.project.exception.movies.exception.DataNotPresent;
import com.event.booking.system.project.service.movies.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping
    public List<User> findAllUsers(@RequestParam(defaultValue = "0") int pageNo,@RequestParam(defaultValue = "5") int pageSize,
                                   UriComponentsBuilder uriBuilder,
                                   HttpServletResponse response){

        Page<User> userPage = userService.findAllUsers(pageNo,pageSize);
        if(pageNo>= userPage.getTotalPages()){
            throw new DataNotPresent("This page does not exsist");
        }

        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<User>(
                User.class, uriBuilder, response, pageNo, userPage.getTotalPages(), pageSize));
        return userPage.getContent();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable long id){
        return this.userService.getUserById(id);
    }

    @GetMapping("/username/{id}")
    public User findUserByUsername(@PathVariable String username){
        return this.userService.getUserByUsername(username);
    }

    @PostMapping
    public String addUser(@Valid @RequestBody User u){
        return "user";
//        this.userService.addUser(u);
    }

    @GetMapping("/add-fake-user/{count}")
    public void addBulkRandomUsers(@PathVariable int count){
        this.userService.saveAll(count);
    }



}
