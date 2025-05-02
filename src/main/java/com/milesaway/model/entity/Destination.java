package com.milesaway.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "destination_type")
@Table(name = "destinations")
public abstract class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    protected Destination() {}

    public Destination(String name, Trip trip) {
        this.name = name;
        this.trip = trip;
    }

}
