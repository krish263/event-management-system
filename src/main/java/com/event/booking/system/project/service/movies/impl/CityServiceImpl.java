package com.event.booking.system.project.service.movies.impl;

import com.event.booking.system.project.dao.movies.CityRepository;
import com.event.booking.system.project.entity.movies.City;
import com.event.booking.system.project.exception.movies.exception.DataNotBeCreated;
import com.event.booking.system.project.exception.movies.exception.DataNotPresent;
import com.event.booking.system.project.service.movies.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository){
        this.cityRepository=cityRepository;
    }

    @Override
    public void addCity(City city){
        try{
            cityRepository.save(city);
        }
        catch(Exception e){
            throw new DataNotBeCreated("Error while creating city");
        }
    }

    @Override
    public City getCity(long id) {

        Optional<City> city = cityRepository.findById(id);
        System.out.println(city);
        if(city.isEmpty()){
//            List<City> cityList = new ArrayList<>();
//            for(int i=0;i<100;i++){
//                Faker faker=new Faker();
//                Address address = faker.address();
//                City city1=new City(address.cityName(),address.zipCode());
//                cityList.add(city1);
//            }
//            this.cityRepository.saveAll(cityList);
            throw new DataNotPresent("No such city is present");
        }

        return city.get();
    }

    @Override
    public City getCityByName(String name) {
        Optional<City> city = Optional.ofNullable(cityRepository.findByCityName(name));
        if(city.isEmpty()){
            throw new DataNotPresent("City with name: "+ name +" does not exist");
        }
        return city.get();
    }

    @Override
    public City getTheaterList(long id) {
        Optional<City> c = cityRepository.findById(id);
        if(c.isEmpty()){
            throw new DataNotPresent("City with given id does not exist");
        }
        c.get().getTheaterList();
        return c.get();
    }
}
