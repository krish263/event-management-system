package com.event.booking.system.project.entity.movies;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "theaters")
public class Theater {

    public Theater(List<Hall> hall, City city, String theaterName) {
        this.hall = hall;
        this.city = city;
        this.theaterName = theaterName;
        this.id=0;
    }

    public Theater(City city, String theaterName) {
        this.city = city;
        this.theaterName = theaterName;
        this.id=0;
    }

    public Theater(){

    }

    @OneToMany(mappedBy = "theater")
    private List<Hall> hall;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city")
    @JsonBackReference
    private City city;

    @Column(name = "theater_name")
    private String theaterName;

    public List<Hall> getHall() {
        return hall;
    }

    public void setHall(List<Hall> hall) {
        this.hall = hall;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }
}
