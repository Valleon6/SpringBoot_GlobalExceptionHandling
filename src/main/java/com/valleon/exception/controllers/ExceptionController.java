package com.valleon.exception.controller;
import com.valleon.exception.handler.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.valleon.exception.handler.UserNotFoundException;

@ControllerAdvice
public class ExceptionController {

    // For UI pages
    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFoundException( UserNotFoundException ex){
        return "error";
    }

    //For Rest APIs
    @ExceptionHandler(IllegalArgumentException.class)
        public ResponseEntity<?> illegalArgumentException (IllegalArgumentException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }


}
