package com.patikapaycore.TourAgencySystem.controller;
import com.patikapaycore.TourAgencySystem.model.Hotel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
   private List<Hotel> hotels= new ArrayList<>();
   {
      hotels.add(new Hotel("Hotel 1"));
      hotels.add(new Hotel("Hotel 2"));
   }
   @GetMapping(path="/all")
    public List<Hotel> getAllHotels(){
       return hotels;
   }
   @PostMapping(path="/add")
   public boolean addHotel(@RequestBody Hotel hotel){
      return hotels.add(hotel);

   }

}
