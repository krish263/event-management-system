package com.event.booking.system.project.exception.movies.handler;

import com.event.booking.system.project.exception.movies.exception.DataNotBeCreated;
import com.event.booking.system.project.exception.movies.exception.DataNotPresent;
import com.event.booking.system.project.exception.movies.exceptionentity.ErrorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class DataExceptionHandler {
    @ExceptionHandler(value = DataNotBeCreated.class)
    public ResponseEntity<Object> handleDataAlreadyExsist(DataNotBeCreated ex){
        HttpStatus serverError = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorEntity error = new ErrorEntity(serverError.value(),ex.getMessage(), LocalDate.now());
        return new ResponseEntity<>(error,serverError);
    }

    @ExceptionHandler(value = DataNotPresent.class)
    public ResponseEntity<Object> handleDataNotExsist(DataNotPresent ex){
        HttpStatus serverError = HttpStatus.NOT_FOUND;
        ErrorEntity error = new ErrorEntity(serverError.value(),ex.getMessage(), LocalDate.now());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erorr");
        return new ResponseEntity<>(error,serverError);
    }


}
