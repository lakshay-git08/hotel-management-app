package com.app.reactive_programming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.app.reactive_programming.entity.Hotel;
import com.app.reactive_programming.input.HotelInput;
import com.app.reactive_programming.input.ModifyHotelInput;
import com.app.reactive_programming.service.HotelService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class HotelGraphqlController {

    @Autowired
    HotelService hotelService;

    @QueryMapping
    public Flux<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @QueryMapping
    public Mono<Hotel> getHotelById(@Argument String id) {
        return hotelService.getHotelById(id);
    }

    @MutationMapping
    public Mono<Hotel> createHotel(@Argument HotelInput input) {
        return hotelService.createHotel(input);
    }

    @MutationMapping
    public Mono<Hotel> updateHotel(@Argument String id, @Argument ModifyHotelInput modifyHotelInput) {
        return hotelService.updateHotel(id, modifyHotelInput);
    }

    @MutationMapping
    public Mono<Boolean> deleteHotel(@Argument String id) {
        return hotelService.deleteHotel(id);
    }

    @MutationMapping
    public Mono<Hotel> approveHotel(@Argument String id) {
        return hotelService.approveHotel(id);
    }

    @MutationMapping
    public Mono<Hotel> rejectHotel(@Argument String id) {
        return hotelService.rejectHotel(id);
    }

}
