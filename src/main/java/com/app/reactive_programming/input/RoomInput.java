package com.app.reactive_programming.input;

import com.app.reactive_programming.enums.RoomType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomInput {
    private RoomType type;

    private int pricePerNight;

    private int totalRooms;

    private int availableRooms;

    private String[] amenities;

    private String[] images;

}
