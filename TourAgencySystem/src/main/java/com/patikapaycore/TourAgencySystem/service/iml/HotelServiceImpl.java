package com.patikapaycore.TourAgencySystem.service.iml;
import com.patikapaycore.TourAgencySystem.exception.NotFoundException;
import com.patikapaycore.TourAgencySystem.model.Address;

import com.patikapaycore.TourAgencySystem.model.entity.Hotel;

import com.patikapaycore.TourAgencySystem.model.entity.Hotel;

import com.patikapaycore.TourAgencySystem.repository.HotelRepository;
import com.patikapaycore.TourAgencySystem.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(Integer id) {
        Optional<Hotel> byId = hotelRepository.findById(id);
        return byId.orElseThrow(() -> new NotFoundException("Hotel"));
    }

    @Override
    public void addHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(Integer id, Hotel hotel) {
        getHotel(id);
        hotel.setId(id);
        return hotelRepository.save(hotel);
    }

    @Override
    public boolean deleteHotel(Integer id) {
        hotelRepository.delete(getHotel(id));
        return true;
    }

    private List<Address> getAddressCityStartsWith(String prefix) {
        List<Hotel> allHotels = getAllHotels();
        return allHotels.stream()
                .map(Hotel::getAddresses)
                .flatMap(Collection::stream)
                .distinct()
                .filter(a -> a.getCity().startsWith(prefix))
                .collect(Collectors.toList());
    }

    private void printAllAdressCityStartsWith(String prefix) {
        List<Address> addressCityStartsWith = getAddressCityStartsWith(prefix);
        addressCityStartsWith.stream()
                .map(address -> address.getCity() + "/" + address.getStreetCode() + "/" +
                        address.getBuildingNo())
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private void reduceAddressListToCityNameAndStreetCode() {
        List<Hotel> allHotels = getAllHotels();
        String reducedAddressList = allHotels.stream()
                .map(Hotel::getAddresses)
                .flatMap(Collection::stream)
                .map(address -> address.getCity() + " " + address.getStreetCode())
                .reduce("", (s1, s2) -> s1 + s2);

        System.out.println("Reduced address List : " + reducedAddressList);
    }

    private String getCombinedAddressOfBoth(Hotel hotel1, Hotel hotel2) {

        BiFunction<Hotel, Hotel, String> function = (a1, a2) -> a1.getAddresses().get(0).getCity() + "-" + a1.getAddresses().get(0).getStreetCode()
                + " ------- " +
                a2.getAddresses().get(0).getCity() + "-" + a2.getAddresses().get(0).getStreetCode();

        // Gets combined Address String
        return function.apply(hotel1, hotel2);
    }

    private void consumeHotelAddresses(Integer hotelId) {
        Hotel hotel = hotelRepository.getById(hotelId);


        Consumer<Hotel> hotelConsumer = hotell -> hotell.getAddresses().forEach(System.out::println);

        hotelConsumer.accept(hotel);
    }

}
