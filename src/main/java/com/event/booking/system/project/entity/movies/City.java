package com.event.booking.system.project.entity.movies;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "city")
public class City {

    public City(String cityName, String pinCode) {
        this.cityName = cityName;
        this.pinCode = pinCode;
        this.id=0;
    }

    public City(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="city_name")
    private String cityName;

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public List<Theater> getTheaterList() {
        return theaterList;
    }

    public void setTheaterList(List<Theater> theaterList) {
        this.theaterList = theaterList;
    }

    @Column(name="state")
    private String State;
    @OneToMany(mappedBy = "city",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Theater> theaterList;

    @Column(name="pin_code")
    private String pinCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", State='" + State + '\'' +
                ", theaterList=" + theaterList +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }
}
