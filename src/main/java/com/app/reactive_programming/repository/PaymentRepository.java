package com.app.reactive_programming.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.app.reactive_programming.entity.Payment;

@Repository
public interface PaymentRepository extends ReactiveMongoRepository<Payment, String> {

}
