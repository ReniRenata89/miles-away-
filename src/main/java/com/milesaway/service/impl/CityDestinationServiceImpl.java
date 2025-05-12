package com.milesaway.service.impl;

import com.milesaway.exception.CityDestinationNotFoundException;
import com.milesaway.model.dto.CityDestinationDTO;
import com.milesaway.model.entity.CityDestination;
import com.milesaway.model.entity.Trip;
import com.milesaway.repository.CityDestinationRepository;
import com.milesaway.repository.TripRepository;
import com.milesaway.service.CityDestinationService;
import com.milesaway.util.CityDestinationConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityDestinationServiceImpl implements CityDestinationService {

    private final CityDestinationRepository cityDestinationRepository;
    private final TripRepository tripRepository;

    public CityDestinationServiceImpl(CityDestinationRepository cityDestinationRepository, TripRepository tripRepository) {
        this.cityDestinationRepository = cityDestinationRepository;
        this.tripRepository = tripRepository;
    }

    @Override
    public CityDestinationDTO findById(Long id) {
        CityDestination destination = cityDestinationRepository.findById(id)
                .orElseThrow(() -> new CityDestinationNotFoundException("Destination with ID " + id + " not found"));
        return CityDestinationConverter.toDTO(destination);
    }

    @Override
    public List<CityDestinationDTO> findAll() {
        return CityDestinationConverter.toDTOList(cityDestinationRepository.findAll());
    }

    @Override
    public CityDestinationDTO create(CityDestinationDTO dto) {
        Trip trip = tripRepository.findById(dto.getTripId())
                .orElseThrow(() -> new CityDestinationNotFoundException("Trip with ID " + dto.getTripId() + " not found"));
        CityDestination destination = CityDestinationConverter.toEntity(dto, trip);
        CityDestination saved = cityDestinationRepository.save(destination);
        return CityDestinationConverter.toDTO(saved);
    }

    @Override
    public void delete(Long id) {
        cityDestinationRepository.deleteById(id);
    }
}