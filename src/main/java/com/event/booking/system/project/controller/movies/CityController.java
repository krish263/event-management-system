package com.event.booking.system.project.controller.movies;


import com.event.booking.system.project.entity.movies.City;
import com.event.booking.system.project.service.movies.CityService;
import com.event.booking.system.project.service.movies.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
public class CityController {

    private CityService cityServiceImpl;

    @Autowired
    public CityController(CityServiceImpl moviesService){
        this.cityServiceImpl =moviesService;
    }

    @PostMapping
    public void addCity(@RequestBody  City city){
        this.cityServiceImpl.addCity(city);
    }



    @GetMapping("/{id}")
    public City getCity(@PathVariable long id){
        return cityServiceImpl.getCity(id);
    }

    @GetMapping("/{id}/theaters")
    public City getTheaterList(@PathVariable long id){
        return cityServiceImpl.getTheaterList(id);
    }

    @GetMapping("/name/{name}")
    public City getCityByName(@PathVariable String name){
        return cityServiceImpl.getCityByName(name);
    }


}
