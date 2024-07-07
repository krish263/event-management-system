package com.event.booking.system.project.controller.movies;


import com.event.booking.system.project.entity.movies.Celebrity;
import com.event.booking.system.project.service.movies.CelebrityService;
import com.event.booking.system.project.service.movies.impl.CelebrityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/celebrity")
public class CelebrityController {

    private final CelebrityService celebrityService;

//    @Autowired
    public CelebrityController(CelebrityServiceImpl celebrityService){
        this.celebrityService=celebrityService;
    }

    @PostMapping
    public void addCelebrity(@RequestBody Celebrity celebrity){
        this.celebrityService.addCelebrity(celebrity);
    }

    @GetMapping("/{id}")
    public Celebrity getCelebrity(@PathVariable long id){
        return this.celebrityService.getCelebrity(id);
    }


}
