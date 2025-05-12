package com.milesaway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CityDestinationNotFoundException extends ResponseStatusException {

    public CityDestinationNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}


