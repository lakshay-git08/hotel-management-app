package com.app.reactive_programming.service;

import com.app.reactive_programming.entity.Booking;
import com.app.reactive_programming.input.BookingInput;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookingService {

    public Flux<Booking> getAllBooking();

    public Mono<Booking> getBookingById(String id);

    public Mono<Booking> createBooking(BookingInput bookingInput);

    public Mono<Booking> confirmBooking(String id);

    public Mono<Booking> cancelBooking(String id);

    public Mono<Booking> checkedInBooking(String id);

    public Mono<Booking> completeBooking(String id);

    public Mono<Booking> getBookingDetails(String id);

}
