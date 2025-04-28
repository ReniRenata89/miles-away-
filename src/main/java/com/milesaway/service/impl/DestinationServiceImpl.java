package com.milesaway.service.impl;

import com.milesaway.model.entity.Destination;
import com.milesaway.repository.DestinationRepository;
import com.milesaway.service.DestinationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationServiceImpl implements DestinationService {

    private final DestinationRepository destinationRepository;

    public DestinationServiceImpl(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Override
    public Destination createDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    @Override
    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    @Override
    public Destination getDestinationById(Long id) {
        return destinationRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteDestination(Long id) {
        destinationRepository.deleteById(id);
    }
}
