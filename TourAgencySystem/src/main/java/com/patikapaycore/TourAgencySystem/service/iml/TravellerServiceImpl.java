package com.patikapaycore.TourAgencySystem.service.iml;
import com.patikapaycore.TourAgencySystem.exception.NotFoundException;
import com.patikapaycore.TourAgencySystem.model.entity.Traveller;
import com.patikapaycore.TourAgencySystem.repository.TravellerRepository;
import com.patikapaycore.TourAgencySystem.service.TravellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TravellerServiceImpl implements TravellerService {

    private final TravellerRepository travellerRepository;

    @Override
    public List<Traveller> getAllTravellers() {
        // business logic
        return travellerRepository.findAll();
    }

    @Override
    public Traveller getTraveller(Integer id) {
        Optional<Traveller> byId = travellerRepository.findById(id);
        return byId.orElseThrow(() -> new NotFoundException("Traveller"));
    }

    @Override
    public void addTraveller(Traveller traveller) {
        travellerRepository.save(traveller);
    }

    @Override
    public Traveller updateTraveller(Traveller traveller) {
        return travellerRepository.save(traveller);
    }

    @Override
    public boolean deleteTraveller(Integer id) {
        travellerRepository.delete(getTraveller(id));
        return true;
    }


    @Override
    public List<Traveller> getTravellersNameStartsWith(String prefix) {
        List<Traveller> allTravellerss = getAllTravellers();
        return allTravellerss.stream()
                .filter(p -> p.getFirstname().startsWith(prefix))
                .collect(Collectors.toList());
    }

    @Override
    public List<Traveller> getTravellersSortedViaLastNameAsUpperCase() {
        List<Traveller> allTravellers = getAllTravellers();
        return allTravellers.stream()
                .sorted(Comparator.comparing(Traveller::getLastname))
                .peek(p -> p.setLastname(p.getLastname().toUpperCase()))
                .collect(Collectors.toList());
    }

    private Traveller getTheOldestMaleTravellerAndLowerCaseFirstLast() {
        List<Traveller> allTravellers = getAllTravellers();
        return allTravellers.stream()
                .max(Comparator.comparing(Traveller::getAge))
                .filter(p -> p.getGender().equals("male"))
                .orElseThrow(() -> new NotFoundException("No matching traveller"));
    }

    private Boolean isAnyTravellerLastNameStartsWithCharAndFemale(String prefix) {
        List<Traveller> allTravellers = getAllTravellers();
        return allTravellers.stream()
                .anyMatch(p -> p.getLastname().startsWith(prefix) && p.getGender().equals("female"));
    }

    private Boolean isAllTravellerFemaleAndAgeBetween(Integer minAge, Integer maxAge) {
        List<Traveller> allTravellers = getAllTravellers();
        return allTravellers.stream()
                .allMatch(p -> p.getGender().equals("female") && (p.getAge() > minAge && p.getAge() < maxAge));
    }

    private Boolean isNoneTravellerFirstNameAndPhoneStartsWith(String firstName, String phonePrefix) {
        List<Traveller> allTravellers = getAllTravellers();
        return allTravellers.stream()
                .noneMatch(p -> p.getFirstname().equals(firstName) && p.getPhone().startsWith(phonePrefix));
    }

    private Integer getCountOfMaleTravellersAgeBetween(Integer minAge, Integer maxAge) {
        List<Traveller> allTravellers = getAllTravellers();
        return (int) allTravellers.stream()
                .filter(p -> p.getGender().equals("male") && (p.getAge() > minAge && p.getAge() < maxAge))
                .count();
    }

    private List<String> getTravellerListAsFirstNameAndLastName() {
        List<Traveller> allTravellers = getAllTravellers();
        return allTravellers.stream()
                .map(p -> p.getFirstname() + " " + p.getLastname())
                .collect(Collectors.toList());
    }

}
