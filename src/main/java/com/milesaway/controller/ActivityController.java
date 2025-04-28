package com.milesaway.controller;

import com.milesaway.model.entity.Activity;
import com.milesaway.service.ActivityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Activity Manager", description = "API for managing activities within trip destinations")
@RestController
@RequestMapping("/activities")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Operation(summary = "Create a new activity", description = "Allows adding a new activity to a destination within a trip.")
    @PostMapping
    public Activity createActivity(@RequestBody Activity activity) {
        return activityService.createActivity(activity);
    }

    @Operation(summary = "Get all activities", description = "Displays all the activities available in the system.")
    @GetMapping
    public List<Activity> getAllActivities() {
        return activityService.getAllActivities();
    }

    @Operation(summary = "Get an activity by ID", description = "Allows retrieving details of an activity by its ID.")
    @GetMapping("/{id}")
    public Activity getActivityById(@PathVariable Long id) {
        return activityService.getActivityById(id);
    }

    @Operation(summary = "Delete an activity", description = "Allows deleting an activity based on its ID.")
    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable Long id) {
        activityService.deleteActivity(id);
    }
}
