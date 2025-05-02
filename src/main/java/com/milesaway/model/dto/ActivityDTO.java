package com.milesaway.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class ActivityDTO {
    private Long id;
    private String name;
    private String description;
    private Double cost;
    private Long destinationId;

    public ActivityDTO(Long id, String name, String description, Double cost, Long destinationId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.destinationId = destinationId;
    }
}