package com.milesaway.model.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity

public class CityDestination extends Destination {

    private String cityInfo;

    public CityDestination() {}

    public CityDestination(String name, Trip trip, String cityInfo) {
        super(name, trip);
        this.cityInfo = cityInfo;
    }
}
