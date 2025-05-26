package com.app.reactive_programming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.app.reactive_programming.entity.Payment;
import com.app.reactive_programming.input.PaymentInput;
import com.app.reactive_programming.service.PaymentService;

import reactor.core.publisher.Mono;

@Controller
public class PaymentGraphqlController {

    @Autowired
    PaymentService paymentService;

    @MutationMapping
    public Mono<Payment> initiatePayment(@Argument String bookingId, @Argument PaymentInput input) {
        return paymentService.initiatePayment(bookingId, input);
    }

    @MutationMapping
    public Mono<Boolean> verifyPayment(@Argument String id) {
        return paymentService.verifyPayment(id);
    }

}
