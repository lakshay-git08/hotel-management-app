package com.app.reactive_programming.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.reactive_programming.entity.Hotel;
import com.app.reactive_programming.entity.HotelAddress;
import com.app.reactive_programming.enums.HotelStatus;
import com.app.reactive_programming.input.HotelInput;
import com.app.reactive_programming.repository.HotelRepository;
import com.app.reactive_programming.service.HotelService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Flux<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Mono<Hotel> getHotelById(String id) {
        return hotelRepository.findById(id);
    }

    @Override
    public Mono<Hotel> createHotel(HotelInput hotelInput) {
        Hotel newHotel = modelMapper.map(hotelInput, Hotel.class);
        newHotel.setStatus(HotelStatus.PENDING);
        return hotelRepository.save(newHotel);
    }

    @Override
    public Mono<Hotel> updateHotel(String id, HotelInput hotelInput) {
        return hotelRepository.findById(id)
                .flatMap(existingHotel -> {
                    existingHotel.setName(hotelInput.getName());
                    existingHotel.setAddress(modelMapper.map(hotelInput.getAddress(), HotelAddress.class));
                    return hotelRepository.save(existingHotel);
                });
    }

    @Override
    public Mono<Boolean> deleteHotel(String id) {
        Mono<Hotel> hotelFromDB = hotelRepository.findById(id);
        if (hotelFromDB != null) {
            hotelRepository.deleteById(id);
            return Mono.just(true);
        }
        return Mono.just(false);
    }

    @Override
    public Mono<Hotel> approveHotel(String id) {
        return hotelRepository.findById(id).flatMap(hotel -> {
            hotel.setStatus(HotelStatus.APPROVED);
            return hotelRepository.save(hotel);
        });
    }

    @Override
    public Mono<Hotel> rejectHotel(String id) {
        return hotelRepository.findById(id).flatMap(hotel -> {
            hotel.setStatus(HotelStatus.REJECTED);
            return hotelRepository.save(hotel);
        });
    }
}
