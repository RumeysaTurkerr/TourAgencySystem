package com.patikapaycore.TourAgencySystem.repository;

import com.patikapaycore.TourAgencySystem.model.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {

   List<Tour> getByPrice(Integer lowPrice,Integer highPrice);

   Tour getAllByNumberOfDays(Integer numberOfDays);
}
