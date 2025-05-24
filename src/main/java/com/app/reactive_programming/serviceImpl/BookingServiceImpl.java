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

    @Override
    public Mono<Booking> createBooking(BookingInput bookingInput) {
        Booking booking = modelMapper.map(bookingInput, Booking.class);
        booking.setBookingStatus(BookingStatus.PENDING);
        return bookingRepository.save(booking);
    }

    @Override
    public Mono<Booking> confirmBooking(String id) {
        return bookingRepository.findById(id).flatMap(booking -> {
            booking.setBookingStatus(BookingStatus.CONFIRMED);
            return bookingRepository.save(booking);
        });
    }

    @Override
    public Mono<Booking> cancelBooking(String id) {
        return bookingRepository.findById(id).flatMap(booking -> {
            booking.setBookingStatus(BookingStatus.CANCELLED);
            return bookingRepository.save(booking);
        });
    }

    @Override
    public Mono<Booking> checkedInBooking(String id) {
        return bookingRepository.findById(id).flatMap(booking -> {
            booking.setBookingStatus(BookingStatus.CHECKED_IN);
            return bookingRepository.save(booking);
        });
    }

    @Override
    public Mono<Booking> completeBooking(String id) {
        return bookingRepository.findById(id).flatMap(booking -> {
            booking.setBookingStatus(BookingStatus.COMPLETED);
            return bookingRepository.save(booking);
        });
    }

}
