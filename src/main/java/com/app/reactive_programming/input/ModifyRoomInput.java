package com.app.reactive_programming.input;

import com.app.reactive_programming.enums.RoomType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ModifyRoomInput {

    private RoomType type;

    private int price;

    private int totalRooms;

    private int availableRooms;

    private String[] amenities;

    private String[] images;

}
