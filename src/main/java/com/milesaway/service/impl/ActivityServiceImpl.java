package com.milesaway.service.impl;

import com.milesaway.model.entity.Activity;
import com.milesaway.repository.ActivityRepository;
import com.milesaway.service.ActivityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public Activity getActivityById(Long id) {
        return activityRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);
    }
}
