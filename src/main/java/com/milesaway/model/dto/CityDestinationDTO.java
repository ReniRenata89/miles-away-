package com.milesaway.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CityDestinationDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String name;
    private String cityInfo;
    private Long tripId;

    public CityDestinationDTO(Long id, String name,
                              String cityInfo, Long tripId) {
        this.id = id;
        this.name = name;
        this.cityInfo = cityInfo;
        this.tripId = tripId;
    }
}