package com.rap.microservices.exceptions;

public class PathNotFoundException extends Exception {

    public PathNotFoundException(final String message) {
        super(message);
    }
}