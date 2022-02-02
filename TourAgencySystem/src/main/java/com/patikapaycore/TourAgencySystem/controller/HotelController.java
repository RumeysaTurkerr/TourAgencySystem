package com.patikapaycore.TourAgencySystem.controller;
import com.patikapaycore.TourAgencySystem.model.Hotel;
import com.patikapaycore.TourAgencySystem.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
   @Autowired
   private HotelService hotelService;

   @GetMapping(path="/all")
    public List<Hotel> getAllHotels(){
       return hotelService.getAllHotels();
   }
   @PostMapping(path="/add")
   public boolean addHotel(@RequestBody Hotel hotel){
      return hotelService.addHotel(hotel);

   }

}
