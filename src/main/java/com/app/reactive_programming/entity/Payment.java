package com.app.reactive_programming.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.app.reactive_programming.enums.PaymentMethod;
import com.app.reactive_programming.enums.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    private String id;

    private String bookingId;

    private String userId;

    private String hotelId;

    private PaymentMethod paymentMethod;

    private double amount;

    private PaymentStatus status;

    private String referenceId;

    private Date createdAt;

    private Date updatedAt;

    private Boolean deleted;

    private Boolean active;

}
