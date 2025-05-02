package com.milesaway.service;

import com.milesaway.model.dto.CityDestinationDTO;
import java.util.List;

public interface CityDestinationService {
    CityDestinationDTO findById(Long id);
    List<CityDestinationDTO> findAll();
    CityDestinationDTO create(CityDestinationDTO dto);
    void delete(Long id);
}
