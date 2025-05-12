package com.milesaway.util;

import com.milesaway.model.dto.TripDTO;
import com.milesaway.model.entity.Trip;
import com.milesaway.model.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class TripConverter {

    public static TripDTO toDTO(Trip trip) {
        return new TripDTO(
                trip.getId(),
                trip.getTitle(),
                trip.getStartDate(),
                trip.getEndDate(),
                trip.getBudget(),
                trip.getUser().getId()
        );
    }

    public static Trip toEntity(TripDTO tripDTO, User user) {
        return new Trip(
                tripDTO.getTitle(),
                tripDTO.getStartDate(),
                tripDTO.getEndDate(),
                tripDTO.getBudget(),
                user,
                null
        );
    }

    public static List<TripDTO> toDTOList(List<Trip> trips) {
        return trips.stream()
                .map(TripConverter::toDTO)
                .collect(Collectors.toList());
    }
}