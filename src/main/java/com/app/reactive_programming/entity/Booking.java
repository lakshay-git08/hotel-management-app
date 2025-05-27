package com.app.reactive_programming.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.app.reactive_programming.enums.BookingStatus;
import com.app.reactive_programming.enums.BookingPaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    private String id;

    private String userId;

    private String hotelId;

    private String roomId;

    private Date checkIn;

    private Date checkOut;

    private int guestCount;

    private int totalAmount;

    private BookingPaymentStatus paymentStatus;

    private BookingStatus bookingStatus;

    private Date createdAt;
    
    private Date statusUpdatedAt;

}
