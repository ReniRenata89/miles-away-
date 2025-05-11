package com.milesaway.service.impl;
import com.milesaway.exception.CityDestinationNotFoundException;
import com.milesaway.model.dto.CityDestinationDTO;
import com.milesaway.model.entity.CityDestination;
import com.milesaway.model.entity.Trip;
import com.milesaway.repository.CityDestinationRepository;
import com.milesaway.repository.TripRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CityDestinationServiceImplTest {

    @Mock
    private CityDestinationRepository cityDestinationRepository;

    @Mock
    private TripRepository tripRepository;

    private CityDestinationServiceImpl cityDestinationService;

    @BeforeEach
    void setUp() {
        cityDestinationService = new CityDestinationServiceImpl(cityDestinationRepository, tripRepository);
    }

    @Test
    void testFindById_success() {
        Trip trip = new Trip();
        trip.setId(1L);

        CityDestination destination = new CityDestination();
        destination.setId(1L);
        destination.setName("Athens");
        destination.setTrip(trip);

        when(cityDestinationRepository.findById(1L)).thenReturn(Optional.of(destination));

        CityDestinationDTO result = cityDestinationService.findById(1L);

        assertEquals("Athens", result.getName());
        assertEquals(1L, result.getTripId());
    }

    @Test
    void testFindById_notFound() {
        when(cityDestinationRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(CityDestinationNotFoundException.class, () -> cityDestinationService.findById(2L));
    }

    @Test
    void testCreate_success() {
        CityDestinationDTO dto = new CityDestinationDTO(null, "Rome", "City trip", 1L);

        Trip trip = new Trip();
        trip.setId(1L);

        CityDestination destination = new CityDestination();
        destination.setId(1L);
        destination.setName("Rome");
        destination.setTrip(trip);

        when(tripRepository.findById(1L)).thenReturn(Optional.of(trip));
        when(cityDestinationRepository.save(any(CityDestination.class))).thenReturn(destination);

        CityDestinationDTO result = cityDestinationService.create(dto);

        assertEquals("Rome", result.getName());
        assertEquals(1L, result.getTripId());
    }

    @Test
    void testFindAll() {
        when(cityDestinationRepository.findAll()).thenReturn(
                java.util.List.of(new CityDestination(), new CityDestination()));

        var results = cityDestinationService.findAll();

        assertNotNull(results);
        assertEquals(2, results.size());
    }

    @Test
    void testDelete() {
        Long idToDelete = 1L;

        doNothing().when(cityDestinationRepository).deleteById(idToDelete);

        cityDestinationService.delete(idToDelete);

        verify(cityDestinationRepository, times(1)).deleteById(idToDelete);
    }
}
