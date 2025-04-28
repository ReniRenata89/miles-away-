package com.milesaway.service.impl;

import com.milesaway.exception.UserNotFoundException;
import com.milesaway.model.entity.Trip;
import com.milesaway.repository.TripRepository;
import com.milesaway.service.TripService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;

    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    @Override
    public Trip getTripById(Long id) {
        return tripRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Trip with ID " + id + " not found."));
    }

    @Override
    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }
}
