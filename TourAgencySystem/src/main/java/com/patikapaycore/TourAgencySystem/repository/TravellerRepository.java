package com.patikapaycore.TourAgencySystem.repository;

import com.patikapaycore.TourAgencySystem.model.entity.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravellerRepository extends JpaRepository<Traveller, Integer> {
}
