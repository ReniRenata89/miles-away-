package com.milesaway.service;

import com.milesaway.model.entity.Trip;

import java.util.List;

public interface TripService {

    Trip createTrip(Trip trip);

    List<Trip> getAllTrips();

    Trip getTripById(Long id);

    void deleteTrip(Long id);
}
