package com.patikapaycore.TourAgencySystem.model.mapper;

import com.patikapaycore.TourAgencySystem.model.entity.Hotel;

import com.patikapaycore.TourAgencySystem.model.HotelDTO;

public class HotelMapper {
    public static HotelDTO toDto(Hotel hotel) {
       HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setName(hotel.getName());

        hotelDTO.setType(hotel.getType());

        hotelDTO.setAddresses(hotel.formatToAddressList());
        return hotelDTO;
    }

    public static Hotel toEntity(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelDTO.getName());

        hotelDTO.setType(hotel.getType());

        hotel.setAddress(hotelDTO.formatAddresses());
        return hotel;
    }
}
