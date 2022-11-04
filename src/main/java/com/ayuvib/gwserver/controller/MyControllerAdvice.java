package com.ayuvib.gwserver.controller;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ayuvib.gwserver.exception.DuplicateException;
import com.ayuvib.gwserver.exception.EmptyException;
import com.ayuvib.gwserver.exception.InvalidInputException;

@ControllerAdvice
public class MyControllerAdvice {
    
    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<String> handleDuplicateInput(DuplicateException duplicateException) {

        return new ResponseEntity<String>("Duplicate input", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyException emptyException) {

        return new ResponseEntity<String>("Empty input", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<String> handleInvalidInput(InvalidInputException invalidInputException) {

        return new ResponseEntity<String>("Invalid input", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException) {

        return new ResponseEntity<String>("No such element exception", HttpStatus.NOT_FOUND);
    }
}
