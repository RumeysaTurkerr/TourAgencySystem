package com.patikapaycore.TourAgencySystem.service;

import com.patikapaycore.TourAgencySystem.model.entity.Traveller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TravellerService {
    List<Traveller> getAllTravellers();

    Traveller getTraveller(Integer id);

    void addTraveller(@RequestBody Traveller traveller);

    Traveller updateTraveller(@RequestBody Traveller traveller);

    boolean deleteTraveller(Integer id);

    List<Traveller> getTravellersNameStartsWith(String prefix);

    List<Traveller> getTravellersSortedViaLastNameAsUpperCase();
}
