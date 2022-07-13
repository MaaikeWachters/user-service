package com.spring_tuesday.user_service.exception;

public class ConstraintViolation extends RuntimeException {


    public ConstraintViolation(String message) {
        super(message);
    }

}
