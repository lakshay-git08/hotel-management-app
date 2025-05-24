package com.app.reactive_programming.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.reactive_programming.entity.Booking;
import com.app.reactive_programming.enums.BookingStatus;
import com.app.reactive_programming.input.BookingInput;
import com.app.reactive_programming.repository.BookingRepository;
import com.app.reactive_programming.service.BookingService;

import reactor.core.publisher.Mono;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    ModelMapper modelMapper;

    public Mono<Booking> createBooking(BookingInput bookingInput) {
        Booking booking = modelMapper.map(bookingInput, Booking.class);
        booking.setBookingStatus(BookingStatus.CONFIRMED);
        return bookingRepository.save(booking);
    }

    public Mono<Booking> cancelBooking(String id) {
        return bookingRepository.findById(id).flatMap(booking -> {
            booking.setBookingStatus(BookingStatus.CANCELLED);
            return bookingRepository.save(booking);
        });

    }

    public Mono<Booking> updateBooking(String id, BookingStatus bookingStatus) {
        return bookingRepository.findById(id).flatMap(existingBooking -> {
            existingBooking.setBookingStatus(bookingStatus);
            return bookingRepository.save(existingBooking);
        });
    }

}
