package com.milesaway.service.impl;

import com.milesaway.model.dto.TripDTO;
import com.milesaway.model.entity.Trip;
import com.milesaway.model.entity.User;
import com.milesaway.repository.TripRepository;
import com.milesaway.repository.UserRepository;
import com.milesaway.service.TripService;
import com.milesaway.util.TripConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.milesaway.exception.TripNotFoundException;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;
    private final UserRepository userRepository;

    @Autowired
    public TripServiceImpl(TripRepository tripRepository, UserRepository userRepository) {
        this.tripRepository = tripRepository;
        this.userRepository = userRepository;
    }

    @Override
    public TripDTO findTripById(Long id) {
        Trip trip = tripRepository.findById(id)
                .orElseThrow(() -> new TripNotFoundException("Trip with ID " + id + " not found"));
        return TripConverter.toDTO(trip);
    }

    @Override
    public List<TripDTO> findAllTrips() {
        return TripConverter.toDTOList(tripRepository.findAll());
    }

    @Override
    public TripDTO createTrip(TripDTO tripDTO) {
        User user = userRepository.findById(tripDTO.getUserId()).orElse(null);
        if (user == null) return null;

        Trip trip = TripConverter.toEntity(tripDTO, user);
        Trip savedTrip = tripRepository.save(trip);
        return TripConverter.toDTO(savedTrip);
    }

    @Override
    public TripDTO updateTrip(Long id, TripDTO tripDTO) {
        return tripRepository.findById(id).map(existingTrip -> {
            existingTrip.setTitle(tripDTO.getTitle());
            existingTrip.setStartDate(tripDTO.getStartDate());
            existingTrip.setEndDate(tripDTO.getEndDate());
            existingTrip.setBudget(tripDTO.getBudget());
            Trip updatedTrip = tripRepository.save(existingTrip);
            return TripConverter.toDTO(updatedTrip);
        }).orElse(null);
    }

    @Override
    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }
}
