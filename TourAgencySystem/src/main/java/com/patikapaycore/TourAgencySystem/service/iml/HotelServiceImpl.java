package com.patikapaycore.TourAgencySystem.service.iml;

import com.patikapaycore.TourAgencySystem.model.Hotel;
import com.patikapaycore.TourAgencySystem.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class HotelServiceImpl implements HotelService {
    private List<Hotel> hotels= new ArrayList<>();
    {
        hotels.add(new Hotel("Hotel 1"));
        hotels.add(new Hotel("Hotel 2"));
    }
    @Override
    public List<Hotel> getAllHotels() {
        return getAllHotels();
    }

    @Override
    public Hotel getHotel(Integer id) {
        return null;
    }

    @Override
    public boolean addHotel(Hotel hotel) {
      return hotels.add(hotel);
    }

    @Override
    public Hotel updateHotel(String name, Hotel hotel) {
        AtomicBoolean status=new AtomicBoolean(false);
    hotels.forEach(hotelItem->{
        if(hotelItem.getName().equals(name)){
            status.set(true);
            hotelItem.setName(hotel.getName());
        }
    });
    if(status.get())
        return hotel;
    return null;
    }

    @Override
    public boolean deleteHotel(Integer id) {
        return false;
    }
}
