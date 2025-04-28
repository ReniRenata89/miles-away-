package com.milesaway.controller;

import com.milesaway.model.entity.Trip;
import com.milesaway.service.TripService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Trip Manager", description = "API for managing user trips")
@RestController
@RequestMapping("/trips")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @Operation(summary = "Create a new trip", description = "Allows a user to create a new trip, including budget, start and end dates.")
    @PostMapping
    public Trip createTrip(@RequestBody Trip trip) {
        return tripService.createTrip(trip);
    }

    @Operation(summary = "Get all trips", description = "Displays all the trips saved in the system.")
    @GetMapping
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @Operation(summary = "Get a trip by ID", description = "Allows retrieving details of a trip based on its ID.")
    @GetMapping("/{id}")
    public Trip getTripById(@PathVariable Long id) {
        return tripService.getTripById(id);
    }

    @Operation(summary = "Delete a trip", description = "Allows deleting a trip from the system by its ID.")
    @DeleteMapping("/{id}")
    public void deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
    }
}
