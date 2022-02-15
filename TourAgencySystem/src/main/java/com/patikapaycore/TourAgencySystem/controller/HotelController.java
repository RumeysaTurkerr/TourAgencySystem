package com.patikapaycore.TourAgencySystem.controller;
import com.patikapaycore.TourAgencySystem.model.entity.Hotel;
import com.patikapaycore.TourAgencySystem.model.HotelDTO;
import com.patikapaycore.TourAgencySystem.model.mapper.HotelMapper;
import com.patikapaycore.TourAgencySystem.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hotel")
public class HotelController {

   private final HotelService hotelService;

   @GetMapping
   public String welcome() {
      return "Welcome to Hotel Service!";
   }

   @GetMapping(value = "/all")
   public List<HotelDTO> getAllHotels() {
      List<Hotel> allHotels = hotelService.getAllHotels();
      return allHotels.stream().map(HotelMapper::toDto).collect(Collectors.toList());
   }

   @GetMapping(value = "/{id}")
   public HotelDTO getHotel(@PathVariable @Min(1) Integer id) {
      return HotelMapper.toDto(hotelService.getHotel(id));
   }

   @PostMapping(value = "/create")
   public void saveHotel(@Valid @RequestBody HotelDTO hotel) {
      hotelService.addHotel(HotelMapper.toEntity(hotel));
   }

   @PutMapping(value = "/update/{id}")
   public HotelDTO updateHotel(@PathVariable @Min(1) Integer id, @Valid @RequestBody HotelDTO hotel) {
      return HotelMapper.toDto(hotelService.updateHotel(id, HotelMapper.toEntity(hotel)));
   }

   @DeleteMapping(value = "/delete")
   public boolean deleteHotel(@RequestParam @Min(1) Integer id) {
      return hotelService.deleteHotel(id);
   }
}
