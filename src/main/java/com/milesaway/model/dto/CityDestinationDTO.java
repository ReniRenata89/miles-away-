package com.milesaway.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class CityDestinationDTO {
    private Long id;
    private String name;
    private String cityInfo;
    private Long tripId;

    public CityDestinationDTO(Long id, String name, String cityInfo, Long tripId) {
        this.id = id;
        this.name = name;
        this.cityInfo = cityInfo;
        this.tripId = tripId;
    }
}