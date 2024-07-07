package com.event.booking.system.project.controller.movies;

import com.event.booking.system.project.entity.movies.Hall;
import com.event.booking.system.project.entity.movies.Theater;
import com.event.booking.system.project.service.movies.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class TheaterController {


    private TheaterService theaterService;

    @Autowired
    public TheaterController(TheaterService theaterService){
        this.theaterService=theaterService;
    }

    @PostMapping
    public void add(@RequestBody Theater theater){
        theaterService.add(theater);
    }

    @GetMapping
    public List<Theater>get(){
        return null;
    }

    @GetMapping("/{city}")
    public List<Theater>getByCityName(@PathVariable String city){
        return theaterService.getByCityName(city);
    }

    @PostMapping("/hall")
    public void addHall(@RequestBody Hall hall){
        theaterService.addHall(hall);
    }

    @GetMapping("/{id}/hall")
    public List<Hall>getHalls(@PathVariable long id){
        return theaterService.getHalls(id);
    }

    @GetMapping("/add-dummy-theater/{cnt}")
    public void addDummyTheater(@PathVariable int cnt){
        theaterService.addDummyTheater(cnt);
    }

    @GetMapping("/add-dummy-halls/{halls}")
    public void addDummyHalls(@PathVariable int cnt){
        theaterService.addDummyHalls(cnt);
    }
}
