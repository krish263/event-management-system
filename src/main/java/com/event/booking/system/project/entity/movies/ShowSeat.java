package com.event.booking.system.project.entity.movies;


import jakarta.persistence.*;

@Entity
@Table(name = "show_seats")
public class ShowSeat {

    public ShowSeat(Seat seat, ShowSeatStatus showSeatStatus, ShowSeatType showSeatType,Show show) {
        this.seat = seat;
        this.showSeatStatus = showSeatStatus;
        this.showSeatType = showSeatType;
        this.show=show;
        this.id=0;
    }

    public ShowSeat(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    private Seat seat;

    @Enumerated(EnumType.STRING)
    private ShowSeatStatus showSeatStatus;

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    @ManyToOne
    private Show show;

    @ManyToOne
    @JoinColumn(name = "show_seat_type")
    private ShowSeatType showSeatType;

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public ShowSeatStatus getShowSeatStatus() {
        return showSeatStatus;
    }

    public void setShowSeatStatus(ShowSeatStatus showSeatStatus) {
        this.showSeatStatus = showSeatStatus;
    }

    public ShowSeatType getShowSeatType() {
        return showSeatType;
    }

    public void setShowSeatType(ShowSeatType showSeatType) {
        this.showSeatType = showSeatType;
    }
}
