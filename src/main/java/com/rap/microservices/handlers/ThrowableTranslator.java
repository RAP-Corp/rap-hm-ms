package com.rap.microservices.handlers;

import com.rap.microservices.exceptions.PathNotFoundException;
import com.rap.microservices.exceptions.UserAlreadyExistsException;
import com.rap.microservices.exceptions.UserNotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

import java.security.spec.InvalidParameterSpecException;

class ThrowableTranslator {

    private final HttpStatus httpStatus;
    private final String message;

    private ThrowableTranslator(final Throwable throwable) {
        this.httpStatus = getStatus(throwable);
        this.message = throwable.getMessage();
    }

    private HttpStatus getStatus(final Throwable error) {
        if (error instanceof InvalidParameterSpecException) {
            return HttpStatus.BAD_REQUEST;
        } else if (error instanceof PathNotFoundException) {
            return HttpStatus.NOT_FOUND;
        } else if (error instanceof UserNotFoundException) {
            return HttpStatus.NOT_FOUND;
        } else if (error instanceof DuplicateKeyException) {
            return HttpStatus.CONFLICT;
        } else if (error instanceof UserNotFoundException) {
            if (error.getCause() instanceof InvalidParameterSpecException)
                return HttpStatus.BAD_REQUEST;
            else
                return HttpStatus.INTERNAL_SERVER_ERROR;
        } else {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    HttpStatus getHttpStatus() {
        return httpStatus;
    }

    String getMessage() {
        return message;
    }

    static <T extends Throwable> Mono<ThrowableTranslator> translate(final Mono<T> throwable) {
        return throwable.flatMap(error -> Mono.just(new ThrowableTranslator(error)));
    }
}