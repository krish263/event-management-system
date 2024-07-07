package com.event.booking.system.project.entity.movies;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "hall")
public class Hall {

    public Hall(String hallNo, Theater theater) {
        this.hallNo = hallNo;
        this.theater = theater;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "hall_no")
    private String hallNo;

    @ManyToOne
    private Theater theater;

    @OneToMany(mappedBy = "hall")
    private List<Seat> seatList;

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHallNo() {
        return hallNo;
    }

    public void setHallNo(String hallNo) {
        this.hallNo = hallNo;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
