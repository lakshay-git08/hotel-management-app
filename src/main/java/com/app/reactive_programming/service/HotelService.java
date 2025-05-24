package com.app.reactive_programming.service;

import com.app.reactive_programming.entity.Hotel;
import com.app.reactive_programming.input.HotelInput;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HotelService {

    public Flux<Hotel> getAllHotels();

    public Mono<Hotel> getHotelById(String id);

    public Mono<Hotel> createHotel(HotelInput hotelInput);

    public Mono<Hotel> updateHotel(String id, HotelInput hotelInput);

    public Mono<Boolean> deleteHotel(String id);

    public Mono<Hotel> approveHotel(String id);

    public Mono<Hotel> rejectHotel(String id);

}
