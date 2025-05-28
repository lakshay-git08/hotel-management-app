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

    @Override
    public Mono<Payment> initiatePayment(String bookingId, PaymentInput paymentInput) {
        Payment newPayment = modelMapper.map(paymentInput, Payment.class);
        newPayment.setBookingId(bookingId);
        newPayment.setPaymentMethod(paymentInput.getPaymentMethod());
        newPayment.setAmount(paymentInput.getAmount());
        newPayment.setStatus(PaymentStatus.PENDING);
        newPayment.setDeleted(false);
        newPayment.setActive(true);
        return paymentRepository.save(newPayment);
    }

    @Override
    public Mono<Boolean> verifyPayment(String id) {
        return paymentRepository.findById(id).flatMap(payment -> {
            if (payment.getStatus().equals(PaymentStatus.SUCCESS)) {
                return Mono.just(true);
            } else {
                return Mono.just(false);
            }
        });
    }
}
