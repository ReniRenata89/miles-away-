package com.milesaway.service;

import com.milesaway.model.entity.Destination;
import java.util.List;

public interface DestinationService {

    Destination createDestination(Destination destination);

    List<Destination> getAllDestinations();

    Destination getDestinationById(Long id);

    void deleteDestination(Long id);
}
