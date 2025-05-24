package com.app.reactive_programming.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.app.reactive_programming.entity.Booking;

public interface BookingRepository extends ReactiveMongoRepository<Booking, String> {

}
