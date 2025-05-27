package com.app.reactive_programming.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.app.reactive_programming.enums.RoomType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    private Date createdAt;

    private Date updatedAt;

}
