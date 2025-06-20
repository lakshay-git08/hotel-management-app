package com.app.reactive_programming.serviceImpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.reactive_programming.entity.Hotel;
import com.app.reactive_programming.entity.HotelAddress;
import com.app.reactive_programming.enums.HotelStatus;
import com.app.reactive_programming.input.HotelInput;
import com.app.reactive_programming.input.ModifyHotelInput;
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
        return hotelRepository.findAllHotels();
    }

    @Override
    public Mono<Hotel> getHotelById(String id) {
        return hotelRepository.findById(id);
    }

    @Override
    public Mono<Hotel> createHotel(HotelInput hotelInput) {
        Hotel newHotel = modelMapper.map(hotelInput, Hotel.class);
        newHotel.setId(null);
        newHotel.setStatus(HotelStatus.PENDING);
        newHotel.setCreatedAt(new Date());
        newHotel.setUpdatedAt(new Date());
        newHotel.setDeleted(false);
        newHotel.setActive(true);
        return hotelRepository.save(newHotel);
    }

    @Override
    public Mono<Hotel> updateHotel(String id, ModifyHotelInput modifyHotelInput) {
        return hotelRepository.findById(id)
                .flatMap(existingHotel -> {
                    existingHotel.setName(modifyHotelInput.getName());
                    existingHotel.setAddress(modelMapper.map(modifyHotelInput.getAddress(), HotelAddress.class));
                    existingHotel.setUpdatedAt(new Date());
                    return hotelRepository.save(existingHotel);
                });
    }

    @Override
    public Mono<Boolean> deleteHotel(String id) {
        return hotelRepository.findById(id).flatMap(hotel -> {
            hotel.setDeleted(true);
            return hotelRepository.save(hotel).then(Mono.just(true));
        }).switchIfEmpty(Mono.just(false));
    }

    @Override
    public Mono<Hotel> approveHotel(String id) {
        return hotelRepository.findById(id).flatMap(hotel -> {
            hotel.setStatus(HotelStatus.APPROVED);
            hotel.setUpdatedAt(new Date());
            return hotelRepository.save(hotel);
        });
    }

    @Override
    public Mono<Hotel> rejectHotel(String id) {
        return hotelRepository.findById(id).flatMap(hotel -> {
            hotel.setStatus(HotelStatus.REJECTED);
            hotel.setUpdatedAt(new Date());
            return hotelRepository.save(hotel);
        });
    }
}
