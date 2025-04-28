package com.milesaway.service;

import com.milesaway.model.entity.Activity;
import java.util.List;

public interface ActivityService {

    Activity createActivity(Activity activity);

    List<Activity> getAllActivities();

    Activity getActivityById(Long id);

    void deleteActivity(Long id);
}
