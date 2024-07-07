package com.event.booking.system.project.exception.movies.exception;

public class DataNotPresent extends RuntimeException{
    public DataNotPresent(){
        super();
    }

    public DataNotPresent(String msg){
        super(msg);
    }
}
