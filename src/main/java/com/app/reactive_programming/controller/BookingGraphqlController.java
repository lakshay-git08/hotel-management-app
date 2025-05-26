package com.app.reactive_programming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.app.reactive_programming.entity.Booking;
import com.app.reactive_programming.input.BookingInput;
import com.app.reactive_programming.service.BookingService;

import reactor.core.publisher.Mono;

@Controller
public class BookingGraphqlController {

    @Autowired
    BookingService bookingService;

    @MutationMapping
    public Mono<Booking> createBooking(@Argument BookingInput input) {
        return bookingService.createBooking(input);
    }

    @MutationMapping
    public Mono<Booking> confirmBooking(@Argument String id) {
        return bookingService.confirmBooking(id);
    }

    @MutationMapping
    public Mono<Booking> cancelBooking(@Argument String id) {
        return bookingService.cancelBooking(id);
    }

    @MutationMapping
    public Mono<Booking> checkedInBooking(@Argument String id) {
        return bookingService.checkedInBooking(id);
    }

    @MutationMapping
    public Mono<Booking> completeBooking(@Argument String id) {
        return bookingService.completeBooking(id);
    }

    @MutationMapping
    public Mono<Booking> getBookingDetails(String id) {
        return bookingService.getBookingDetails(id);
    }

}
