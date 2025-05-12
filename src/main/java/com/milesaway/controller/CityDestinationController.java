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
        return ResponseEntity.ok(cityDestinationService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CityDestinationDTO>> getAll() {
        return ResponseEntity.ok(cityDestinationService.findAll());
    }

    @PostMapping
    public ResponseEntity<CityDestinationDTO> create(@RequestBody CityDestinationDTO dto) {
        return ResponseEntity.ok(cityDestinationService.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cityDestinationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}