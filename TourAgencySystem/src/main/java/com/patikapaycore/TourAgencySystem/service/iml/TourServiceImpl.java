package com.patikapaycore.TourAgencySystem.service.iml;

import com.patikapaycore.TourAgencySystem.exception.NotFoundException;
import com.patikapaycore.TourAgencySystem.model.entity.Tour;
import com.patikapaycore.TourAgencySystem.repository.TourRepository;
import com.patikapaycore.TourAgencySystem.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;

    @Override
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    @Override
    public Tour getTour(Integer id) {
        Optional<Tour> byId = tourRepository.findById(id);
        return byId.orElseThrow(() -> new NotFoundException("Tour"));
    }

    @Override
    public void addTour(Tour tour) {
        tourRepository.save(tour);
    }

    @Override
    public Tour updateTour(Tour tour) {
        return tourRepository.save(tour);
    }

    @Override
    public boolean deleteTour(Integer id) {
        tourRepository.delete(getTour(id));
        return true;
    }


    @Override
    public List<Tour> getByPrice(Integer lowPrice, Integer highPrice) {
        return null;
    }

    @Override
    public Tour getAllByNumberOfDays(Integer numberOfDays) {
        return null;
    }
}
