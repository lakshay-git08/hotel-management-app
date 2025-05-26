package com.app.reactive_programming.service;

import com.app.reactive_programming.entity.Payment;
import com.app.reactive_programming.input.PaymentInput;

import reactor.core.publisher.Mono;

public interface PaymentService {

    public Mono<Payment> initiatePayment(String bookingId, PaymentInput paymentInput);

    public Mono<Boolean> verifyPayment(String referenceId);

}
