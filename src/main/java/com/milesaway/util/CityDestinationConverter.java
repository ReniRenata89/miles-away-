package com.milesaway.util;

import com.milesaway.model.dto.CityDestinationDTO;
import com.milesaway.model.entity.CityDestination;
import com.milesaway.model.entity.Trip;

import java.util.List;
import java.util.stream.Collectors;

public class CityDestinationConverter {

    public static CityDestinationDTO toDTO(CityDestination destination) {
        return new CityDestinationDTO(
                destination.getId(),
                destination.getName(),
                destination.getCityInfo(),
                destination.getTrip() != null ? destination.getTrip().getId() : null
        );
    }

    public static CityDestination toEntity(CityDestinationDTO dto, Trip trip) {
        return new CityDestination(dto.getName(), trip, dto.getCityInfo());
    }

    public static List<CityDestinationDTO> toDTOList(List<CityDestination> destinations) {
        return destinations.stream()
                .map(CityDestinationConverter::toDTO)
                .collect(Collectors.toList());
    }
}