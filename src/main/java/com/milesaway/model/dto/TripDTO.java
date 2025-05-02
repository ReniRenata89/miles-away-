package com.milesaway.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter

public class TripDTO {
    private Long id;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double budget;
    private Long userId;


    public TripDTO(Long id, String title, LocalDate startDate,
                   LocalDate endDate, Double budget, Long userId) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.userId = userId;
    }
}