package com.app.reactive_programming.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.app.reactive_programming.enums.PaymentMethod;
import com.app.reactive_programming.enums.PaymentStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Payment {

    @Id
    private String id;

    private String bookingId;

    private PaymentMethod paymentMethod;

    private int amount;

    private PaymentStatus status;

    private String transactionId;

    private Date timestamp;

}
