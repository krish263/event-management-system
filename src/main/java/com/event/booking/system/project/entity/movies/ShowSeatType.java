package com.event.booking.system.project.entity.movies;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "show_seats_type")
public class ShowSeatType {

    public ShowSeatType(SeatType seatType, List<ShowSeat> showSeatList, double cost) {
        this.seatType = seatType;
        this.showSeatList = showSeatList;
        this.cost = cost;
    }

    public ShowSeatType(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @OneToMany(mappedBy = "showSeatType")
    private List<ShowSeat> showSeatList;

    public List<ShowSeat> getShowSeatList() {
        return showSeatList;
    }

    public void setShowSeatList(List<ShowSeat> showSeatList) {
        this.showSeatList = showSeatList;
    }

    private double cost;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
