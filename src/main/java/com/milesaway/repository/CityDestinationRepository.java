package com.milesaway.repository;

import com.milesaway.model.entity.CityDestination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDestinationRepository extends JpaRepository<CityDestination, Long> {
}
