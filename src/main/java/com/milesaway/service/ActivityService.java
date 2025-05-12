package com.milesaway.service;

import com.milesaway.model.dto.ActivityDTO;
import java.util.List;

public interface ActivityService {

    ActivityDTO findById(Long id);

    List<ActivityDTO> findAll();

    ActivityDTO create(ActivityDTO dto);

    void delete(Long id);
}