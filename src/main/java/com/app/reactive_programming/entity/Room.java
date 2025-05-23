package com.app.reactive_programming.entity;

import org.springframework.data.annotation.Id;

import com.app.reactive_programming.enums.RoomType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Room {

    @Id
    private String id;

    private String hotelId;

    private RoomType type;

    private double price;

    private double discountedPrice;

    private int totalRooms;

    private int availableRooms;

    private String[] amenities;

    private String[] images;

}
