package com.milesaway.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripDTO {

    private Long id;
    private String name;
    private String startDate;
    private String endDate;
    private Double budget;
    private Long userId;
}
