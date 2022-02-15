package com.patikapaycore.TourAgencySystem.repository;

import com.patikapaycore.TourAgencySystem.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {
}
