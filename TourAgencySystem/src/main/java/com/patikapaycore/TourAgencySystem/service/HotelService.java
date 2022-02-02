package com.patikapaycore.TourAgencySystem.service;

import com.patikapaycore.TourAgencySystem.model.Hotel;

import java.util.List;

public interface HotelService {

        List<Hotel> getAllHotels();

        Hotel getHotel(Integer id);

        boolean addHotel(Hotel hotel);

        Hotel updateHotel(String name, Hotel hotel);

        boolean deleteHotel(Integer id);

}
