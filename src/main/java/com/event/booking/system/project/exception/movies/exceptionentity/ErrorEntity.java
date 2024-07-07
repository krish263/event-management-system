package com.event.booking.system.project.exception.movies.exceptionentity;


import org.springframework.http.HttpStatus;

import java.time.LocalDate;

public class ErrorEntity {
    private int status;
    private String message;

    private LocalDate timeStamp;

    public ErrorEntity(){

    }

    public ErrorEntity(int status, String message, LocalDate timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }
}
