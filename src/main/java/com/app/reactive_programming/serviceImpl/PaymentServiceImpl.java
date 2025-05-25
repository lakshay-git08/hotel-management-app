package com.app.reactive_programming.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.reactive_programming.entity.Payment;
import com.app.reactive_programming.enums.PaymentStatus;
import com.app.reactive_programming.input.PaymentInput;
import com.app.reactive_programming.repository.PaymentRepository;
import com.app.reactive_programming.service.PaymentService;

import reactor.core.publisher.Mono;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    ModelMapper modelMapper;

    public Mono<Payment> initiatePayment(String bookingId, PaymentInput paymentInput) {

        Payment newPayment = modelMapper.map(paymentInput, Payment.class);
        newPayment.setBookingId(bookingId);
        newPayment.setPaymentMethod(paymentInput.getPaymentMethod());
        newPayment.setAmount(paymentInput.getAmount());
        newPayment.setStatus(PaymentStatus.PENDING);
        return paymentRepository.save(newPayment);
    }

    public Mono<Payment> verifyPayment(String referenceId) {
        return null;
    }

}
