package com.app.reactive_programming.input;

import com.app.reactive_programming.enums.PaymentMethod;
import com.app.reactive_programming.enums.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PaymentInput {

    private String bookingId;

    private PaymentMethod paymentMethod;

    private int amount;

    private PaymentStatus status;

    private String transactionId;

}
