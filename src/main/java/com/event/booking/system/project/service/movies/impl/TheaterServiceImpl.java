package com.event.booking.system.project.service.movies.impl;

import com.event.booking.system.project.dao.movies.HallRepository;
import com.event.booking.system.project.dao.movies.TheaterRepository;
import com.event.booking.system.project.entity.movies.*;
import com.event.booking.system.project.exception.movies.exception.DataNotBeCreated;
import com.event.booking.system.project.exception.movies.exception.DataNotPresent;
import com.event.booking.system.project.service.movies.CityService;
import com.event.booking.system.project.service.movies.TheaterService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class TheaterServiceImpl implements TheaterService {

    private HallRepository hallRepository;

    private TheaterRepository theaterRepository;

    private CityService cityService;

    @Autowired
    public TheaterServiceImpl(TheaterRepository theaterRepository,HallRepository hallRepository,CityService cityService){
        this.theaterRepository=theaterRepository;
        this.hallRepository=hallRepository;
        this.cityService=cityService;
    }

    @Override
    public void add(Theater theater) {
        try{
            this.theaterRepository.save(theater);
        }
        catch (Exception e){
            throw new DataNotBeCreated("Can not create new theater");
        }

    }

    @Override
    public List<Theater> get() {
        return null;
    }

    @Override
    public List<Theater> getByCityName(String city) {
        List<Theater> theater = theaterRepository.fetchByCityName(city);
        if(theater.isEmpty()){
            throw new DataNotPresent("No Theater present in given city");
        }

        return theater;
    }

    @Override
    public void addHall(Hall hall) {
        try{
            this.hallRepository.save(hall);
        }
        catch (Exception e){
            throw new DataNotBeCreated("Can not add new hall in given theater");
        }
    }

    @Override
    public List<Hall> getHalls(long id) {
        List<Hall>halls =  hallRepository.findHallByID(id);

        if(halls.isEmpty()){
            throw new DataNotPresent("No Halls present in given Theater");
        }

        return halls;
    }

    @Override
    public void addDummyTheater(int cnt) {
        List<Theater>theaters = new ArrayList<>();
        Random random = new Random();

        for(int i=0;i<cnt;i++){
            Faker faker=new Faker();
            String name = faker.company().name();

            int cityId = random.nextInt(10)+1;
            City city = cityService.getCity(cityId);
            Theater t = new Theater(city,name);

            theaters.add(t);
        }
        this.theaterRepository.saveAll(theaters);
    }

    @Override
    public void addDummyHalls(int cnt) {
        List<Hall>halls = new ArrayList<>();
        Random random = new Random();

        for(int i=0;i<cnt;i++){
            int theaterId = random.nextInt(20)+1;
            int hallNo = random.nextInt(10)+1;
            Theater t = this.getById(theaterId);
            Hall h = new Hall(Integer.toString(hallNo),t);

            halls.add(h);
        }
        this.hallRepository.saveAll(halls);
    }

    @Override
    public Theater getById(long id) {
        Optional<Theater> t = theaterRepository.findById(id);
        if(t.isEmpty()){
            throw new DataNotPresent("No such Theater is present");
        }
        return t.get();
    }


}
