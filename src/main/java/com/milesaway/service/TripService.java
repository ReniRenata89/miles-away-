package com.milesaway.service;

import com.milesaway.model.dto.TripDTO;
import java.util.List;

public interface TripService {
    TripDTO findTripById(Long id);
    List<TripDTO> findAllTrips();
    TripDTO createTrip(TripDTO tripDTO);
    TripDTO updateTrip(Long id, TripDTO tripDTO);
    void deleteTrip(Long id);
}
