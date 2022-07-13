package com.spring_tuesday.user_service.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super ("Cannot find user with id: " + id );
    }

    public UserNotFoundException(String username) {
        super ("Cannot find user with username: " + username );
    }
}
