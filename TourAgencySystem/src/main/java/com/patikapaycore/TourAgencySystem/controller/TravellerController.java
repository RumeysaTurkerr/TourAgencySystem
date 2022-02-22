package com.patikapaycore.TourAgencySystem.controller;
import com.patikapaycore.TourAgencySystem.exception.InvalidRequestException;
import com.patikapaycore.TourAgencySystem.model.TravellerDTO;
import com.patikapaycore.TourAgencySystem.model.entity.Traveller;
import com.patikapaycore.TourAgencySystem.model.mapper.TravellerMapper;
import com.patikapaycore.TourAgencySystem.service.TravellerService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/traveller")
public class TravellerController {

    private final TravellerService travellerService;
    private static final TravellerMapper TRAVELLER_MAPPER = Mappers.getMapper(TravellerMapper.class);

    @GetMapping
    public String welcome() {
        return "Welcome to Traveller Service!";
    }

    @GetMapping(value = "/all")
    public List<TravellerDTO> getAllTravellers() {
        List<Traveller> allTravellers = travellerService.getAllTravellers();
        return allTravellers.stream().map(TRAVELLER_MAPPER::toDto).collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public TravellerDTO getTraveller(@PathVariable @Min(1) Integer id) {
        return TRAVELLER_MAPPER.toDto(travellerService.getTraveller(id));
    }

    @PostMapping(value = "/create")
    public void saveTraveller(@Valid @RequestBody TravellerDTO traveller) {
        travellerService.addTraveller(TRAVELLER_MAPPER.toEntity(traveller));
    }

    @PutMapping(value = "/update")
    public TravellerDTO updateTraveller(@Valid @RequestBody Traveller traveller) {
        if (traveller.getId() == null) {
            throw new InvalidRequestException("Traveller id can not be null for update!");
        }
        return TRAVELLER_MAPPER.toDto(travellerService.updateTraveller(traveller));
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteTraveller(@RequestParam @Min(1) Integer id) {
        return travellerService.deleteTraveller(id);
    }
}
