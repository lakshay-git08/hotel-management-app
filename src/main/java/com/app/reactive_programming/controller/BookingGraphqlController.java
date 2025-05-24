package com.app.reactive_programming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Controller;

import com.app.reactive_programming.entity.Booking;
import com.app.reactive_programming.enums.BookingStatus;
import com.app.reactive_programming.input.BookingInput;
import com.app.reactive_programming.service.BookingService;

import reactor.core.publisher.Mono;

@Controller
public class BookingGraphqlController {

    @Autowired
    BookingService bookingService;

    public Mono<Booking> createBooking(@Argument BookingInput input) {
        return bookingService.createBooking(input);
    }

    public Mono<Booking> cancelBooking(@Argument String id) {
        return bookingService.cancelBooking(id);
    }

    public Mono<Booking> updateBooking(@Argument String id, @Argument BookingStatus status) {
        return bookingService.updateBooking(id, status);
    }

}
