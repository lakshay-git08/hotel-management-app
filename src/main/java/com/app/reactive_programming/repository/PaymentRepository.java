package com.app.reactive_programming.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.app.reactive_programming.entity.Payment;

public interface PaymentRepository extends ReactiveMongoRepository<Payment, String> {

}
