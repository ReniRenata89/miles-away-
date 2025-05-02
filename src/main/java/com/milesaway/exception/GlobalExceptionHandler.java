package com.milesaway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex) {
        return ResponseEntity.status (HttpStatus.NOT_FOUND) .body(ex.getMessage());
    }

    @ExceptionHandler(TripNotFoundException.class)
    public ResponseEntity<String> handleTripNotFound(TripNotFoundException ex) {
        return ResponseEntity.status (HttpStatus.NOT_FOUND) .body(ex.getMessage());
    }

    @ExceptionHandler(CityDestinationNotFoundException.class)
    public ResponseEntity<String> handleCityDestinationNotFound(CityDestinationNotFoundException ex) {
        return ResponseEntity.status (HttpStatus.NOT_FOUND) .body(ex.getMessage());
    }

    @ExceptionHandler(ActivityNotFoundException.class)
    public ResponseEntity<String> handleActivityNotFound(ActivityNotFoundException ex) {
        return ResponseEntity.status (HttpStatus.NOT_FOUND) .body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleOtherExceptions(Exception ignored) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR) .body("An unexpected error occurred.");
    }
}