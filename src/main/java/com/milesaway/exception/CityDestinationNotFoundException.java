package com.milesaway.exception;

public class CityDestinationNotFoundException extends RuntimeException {
    public CityDestinationNotFoundException(String message) {
        super(message);
    }
}
