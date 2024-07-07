package com.event.booking.system.project.entity.movies;

import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {

    public Seat(int row, int col, SeatWorkingStatus seatWorkingStatus,Hall hall) {
        this.seat_row = row;
        this.seat_col = col;
        this.hall = hall;
        this.seatWorkingStatus = seatWorkingStatus;
        this.id=0;
    }

    public Seat(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int seat_row;
    private int seat_col;

    @ManyToOne
    private Hall hall;

    @Enumerated(EnumType.STRING)
    private SeatWorkingStatus seatWorkingStatus;

    public int getSeat_row() {
        return seat_row;
    }

    public void setSeat_row(int seat_row) {
        this.seat_row = seat_row;
    }

    public int getSeat_col() {
        return seat_col;
    }

    public void setSeat_col(int seat_col) {
        this.seat_col = seat_col;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public SeatWorkingStatus getSeatWorkingStatus() {
        return seatWorkingStatus;
    }

    public void setSeatWorkingStatus(SeatWorkingStatus seatWorkingStatus) {
        this.seatWorkingStatus = seatWorkingStatus;
    }
}
