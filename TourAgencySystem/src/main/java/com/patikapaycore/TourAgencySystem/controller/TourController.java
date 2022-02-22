package com.patikapaycore.TourAgencySystem.controller;
import com.patikapaycore.TourAgencySystem.model.entity.Tour;
import com.patikapaycore.TourAgencySystem.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tour")
public class TourController {
    private final TourService tourService;

    @GetMapping
    public String welcome() {
        return "Welcome to Tour Service!";
    }

    @GetMapping(value = "/all")
    public List<Tour> getAllTours() {
        return tourService.getAllTours();
    }

    @GetMapping(value = "/{id}")
    public Tour getTour(@PathVariable @Min(1) Integer id) {
        return tourService.getTour(id);
    }

    @PostMapping(value = "/create")
    public void saveTour(@Valid @RequestBody Tour flight) {
        tourService.addTour(flight);
    }

    @PutMapping(value = "/update")
    public Tour updateTour(@Valid @RequestBody Tour flight) {
        return tourService.updateTour(flight);
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteTour(@RequestParam @Min(1) Integer id) {
        return tourService.deleteTour(id);
    }
    @GetMapping("/by-numberOfDays/{numberOfDays}")
    public Tour getAllByNumberOfDays(@PathVariable Integer numberOfDays) {
        return tourService.getAllByNumberOfDays(numberOfDays);
    }
/*
    @GetMapping(value = "/all/betweenPrices")
    public List<Tour> getByPrice(@Valid  @RequestParam Integer lowPrice,
                                                          @Valid @RequestParam Integer highPrice) {
        List<Integer> result = new ArrayList<>();
        for (int i = lowPrice; i <highPrice; i++) {
            result.add(i);

        }
        return tourService.getByPrice(lowPrice,highPrice);
    }*/

}
