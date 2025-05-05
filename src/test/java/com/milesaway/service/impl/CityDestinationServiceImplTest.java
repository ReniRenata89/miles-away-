package com.milesaway.service.impl;

import com.milesaway.exception.CityDestinationNotFoundException;
import com.milesaway.model.dto.CityDestinationDTO;
import com.milesaway.model.entity.CityDestination;
import com.milesaway.model.entity.Trip;
import com.milesaway.repository.CityDestinationRepository;
import com.milesaway.repository.TripRepository;
import com.milesaway.util.CityDestinationConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CityDestinationServiceImplTest {

    @Mock
    private CityDestinationRepository cityDestinationRepository;

    @Mock
    private TripRepository tripRepository;

    @InjectMocks
    private CityDestinationServiceImpl cityDestinationService;

    @Test
    public void testFindById_success() {
        CityDestination destination = new CityDestination();
        destination.setId(1L);
        destination.setName("Athens");

        when(cityDestinationRepository.findById(1L)).thenReturn(Optional.of(destination));

        CityDestinationDTO result = cityDestinationService.findById(1L);

        assertEquals("Athens", result.getName());
    }

    @Test
    public void testFindById_notFound() {
        when(cityDestinationRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(CityDestinationNotFoundException.class, () -> cityDestinationService.findById(2L));
    }

    @Test
    public void testCreate_success() {
        CityDestinationDTO dto = new CityDestinationDTO(null, "Rome", "City trip", 1L);
        Trip trip = new Trip();
        trip.setId(1L);

        CityDestination destination = new CityDestination();
        destination.setId(1L);
        destination.setName("Rome");

        when(tripRepository.findById(1L)).thenReturn(Optional.of(trip));
        when(cityDestinationRepository.save(any(CityDestination.class))).thenReturn(destination);

        CityDestinationDTO result = cityDestinationService.create(dto);

        assertEquals("Rome", result.getName());
    }
}
