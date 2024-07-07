package com.event.booking.system.project.service.movies.impl;

import com.event.booking.system.project.dao.movies.CelebrityRepository;
import com.event.booking.system.project.entity.movies.Celebrity;
import com.event.booking.system.project.exception.movies.exception.DataNotBeCreated;
import com.event.booking.system.project.exception.movies.exception.DataNotPresent;
import com.event.booking.system.project.service.movies.CelebrityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CelebrityServiceImpl implements CelebrityService {

    private final CelebrityRepository celebrityRepository;

    @Autowired
    public CelebrityServiceImpl(CelebrityRepository celebrityRepository){
        this.celebrityRepository=celebrityRepository;
    }

    @Override
    public void addCelebrity(Celebrity celebrity){
        try{
            this.celebrityRepository.save(celebrity);
        }
        catch (Exception e){
            throw new DataNotBeCreated(e.getMessage());
        }

    }

    @Override
    public Celebrity getCelebrity(long id){
        Optional<Celebrity> celebrity= Optional.ofNullable(this.celebrityRepository.getCelebrityById(id));

        if(celebrity.isEmpty()){
//            List<Celebrity> celebrityList = new ArrayList<>();
//            for(int i=0;i<100;i++){
//                Faker faker=new Faker();
//                String firstName = faker.name().firstName();
//                String lastName = faker.name().lastName();
////                GameOfThrones gameOfThrones = faker.gameOfThrones();
//                Celebrity celeb = new Celebrity(firstName,lastName,faker.chuckNorris().fact());
//                celebrityList.add(celeb);
//            }
//            this.celebrityRepository.saveAll(celebrityList);
            throw new DataNotPresent("No such celebrity present");
        }

        return celebrity.get();
    }
}
