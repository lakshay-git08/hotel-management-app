package com.app.reactive_programming.input;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingInput {

    private String userId;

    private String hotelId;

    private String roomId;

    private Date checkIn;

    private Date checkOut;

    private int guestCount;

    private int totalAmount;
}
