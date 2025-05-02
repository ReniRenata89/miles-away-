package com.milesaway.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity

@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double cost;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    public Activity() {}

    public Activity(String name, String description, Double cost, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.destination = destination;
    }
}