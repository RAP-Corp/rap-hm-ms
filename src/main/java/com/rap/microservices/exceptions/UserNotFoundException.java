package com.rap.microservices.exceptions;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(final String message) {
        super(message);
    }
}
