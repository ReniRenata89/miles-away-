package com.milesaway.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDTO {

    private Long id;
    private String name;
    private String description;
    private Long destinationId;
}
