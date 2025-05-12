package com.milesaway.util;

import com.milesaway.model.dto.ActivityDTO;
import com.milesaway.model.entity.Activity;
import com.milesaway.model.entity.Destination;

import java.util.List;
import java.util.stream.Collectors;

public class ActivityConverter {

    public static ActivityDTO toDTO(Activity activity) {
        return new ActivityDTO(
                activity.getId(),
                activity.getName(),
                activity.getDescription(),
                activity.getCost(),
                activity.getDestination().getId()
        );
    }

    public static Activity toEntity(ActivityDTO dto, Destination destination) {
        return new Activity(dto.getName(), dto.getDescription(), dto.getCost(), destination);
    }

    public static List<ActivityDTO> toDTOList(List<Activity> activities) {
        return activities.stream()
                .map(ActivityConverter::toDTO)
                .collect(Collectors.toList());
    }
}