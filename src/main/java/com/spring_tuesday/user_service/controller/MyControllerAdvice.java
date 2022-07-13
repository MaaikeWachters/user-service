package com.spring_tuesday.user_service.controller;

import com.spring_tuesday.user_service.exception.ConstraintViolation;
import com.spring_tuesday.user_service.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyControllerAdvice {
    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundHandler(UserNotFoundException userNotFoundException) {
        return userNotFoundException.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ConstraintViolation.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String constraintViolation(ConstraintViolation constraintViolationException) {
        return "Username already exists";
    }
}
