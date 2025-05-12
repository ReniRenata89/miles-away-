package com.milesaway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ActivityNotFoundException extends ResponseStatusException {

    public ActivityNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}