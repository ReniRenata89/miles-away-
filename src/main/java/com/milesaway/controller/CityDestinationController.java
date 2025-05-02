package com.milesaway.controller;

import com.milesaway.model.dto.CityDestinationDTO;
import com.milesaway.service.CityDestinationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Destination Manager", description = "API for managing city destinations")
@RestController
@RequestMapping("/api/destinations")
public class CityDestinationController {

    private final CityDestinationService cityDestinationService;

    @Autowired
    public CityDestinationController(CityDestinationService cityDestinationService) {
        this.cityDestinationService = cityDestinationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDestinationDTO> getById(@PathVariable Long id) {
        CityDestinationDTO dto = cityDestinationService.findById(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CityDestinationDTO>> getAll() {
        return ResponseEntity.ok(cityDestinationService.findAll());
    }

    @PostMapping
    public ResponseEntity<CityDestinationDTO> create(@RequestBody CityDestinationDTO dto) {
        CityDestinationDTO created = cityDestinationService.create(dto);
        if (created != null) {
            return ResponseEntity.ok(created);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cityDestinationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
