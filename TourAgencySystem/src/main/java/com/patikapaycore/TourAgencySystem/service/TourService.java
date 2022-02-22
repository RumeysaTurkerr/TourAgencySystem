package com.patikapaycore.TourAgencySystem.service;

import com.patikapaycore.TourAgencySystem.model.entity.Tour;

import java.util.List;

public interface TourService {
    List<Tour> getAllTours();

    Tour getTour(Integer id);

    void addTour(Tour tour);

    Tour updateTour(Tour tour);

    boolean deleteTour(Integer id);

   List<Tour> getByPrice(Integer lowPrice, Integer highPrice);

    Tour getAllByNumberOfDays(Integer numberOfDays);

}
