package com.milesaway.service.impl;

import com.milesaway.exception.ActivityNotFoundException;
import com.milesaway.model.dto.ActivityDTO;
import com.milesaway.model.entity.Activity;
import com.milesaway.model.entity.Destination;
import com.milesaway.repository.ActivityRepository;
import com.milesaway.repository.DestinationRepository;
import com.milesaway.service.ActivityService;
import com.milesaway.util.ActivityConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;
    private final DestinationRepository destinationRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository, DestinationRepository destinationRepository) {
        this.activityRepository = activityRepository;
        this.destinationRepository = destinationRepository;
    }

    @Override
    public ActivityDTO findById(Long id) {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new ActivityNotFoundException("Activity with ID " + id + " not found"));
        return ActivityConverter.toDTO(activity);
    }

    @Override
    public List<ActivityDTO> findAll() {
        return ActivityConverter.toDTOList(activityRepository.findAll());
    }

    @Override
    public ActivityDTO create(ActivityDTO dto) {
        Destination destination = destinationRepository.findById(dto.getDestinationId())
                .orElseThrow(() -> new ActivityNotFoundException("Destination with ID " + dto.getDestinationId() + " not found"));
        Activity activity = ActivityConverter.toEntity(dto, destination);
        Activity saved = activityRepository.save(activity);
        return ActivityConverter.toDTO(saved);
    }

    @Override
    public void delete(Long id) {
        activityRepository.deleteById(id);
    }
}