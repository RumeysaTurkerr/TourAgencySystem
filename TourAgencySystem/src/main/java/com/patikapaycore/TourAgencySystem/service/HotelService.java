package com.patikapaycore.TourAgencySystem.service;

import com.patikapaycore.TourAgencySystem.model.Hotel;

import java.util.List;

public interface HotelService {

        List<Hotel> getAllHotels();

        Hotel getHotel(Integer id);

        void addHotel(Hotel hotel);

        Hotel updateHotel(Integer id, Hotel hotel);

        boolean deleteHotel(Integer id);

}
