package com.milesaway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TripNotFoundException extends ResponseStatusException {

    public TripNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
