package com.milesaway.controller;

import com.milesaway.model.entity.Destination;
import com.milesaway.service.DestinationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Destination Manager", description = "API for managing destinations within trips")
@RestController
@RequestMapping("/destinations")
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @Operation(summary = "Create a new destination", description = "Allows a user to add a new destination to an existing trip.")
    @PostMapping
    public Destination createDestination(@RequestBody Destination destination) {
        return destinationService.createDestination(destination);
    }

    @Operation(summary = "Get all destinations", description = "Displays all the destinations available in the system.")
    @GetMapping
    public List<Destination> getAllDestinations() {
        return destinationService.getAllDestinations();
    }

    @Operation(summary = "Get a destination by ID", description = "Allows retrieving details of a destination by its ID.")
    @GetMapping("/{id}")
    public Destination getDestinationById(@PathVariable Long id) {
        return destinationService.getDestinationById(id);
    }

    @Operation(summary = "Delete a destination", description = "Allows deleting a destination based on its ID.")
    @DeleteMapping("/{id}")
    public void deleteDestination(@PathVariable Long id) {
        destinationService.deleteDestination(id);
    }
}
