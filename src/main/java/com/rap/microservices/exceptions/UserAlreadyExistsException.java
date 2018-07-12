package com.rap.microservices.exceptions;

import org.springframework.dao.DuplicateKeyException;

public class UserAlreadyExistsException extends DuplicateKeyException {

    public UserAlreadyExistsException(final String message) {
        super(message);
    }
}
