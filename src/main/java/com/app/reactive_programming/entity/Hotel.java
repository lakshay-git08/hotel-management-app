package com.app.reactive_programming.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.app.reactive_programming.enums.HotelStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hotel {

    @Id
    private String id;

    private String userId;

    private String name;

    private String description;

    private HotelAddress address;

    private String[] amenities;

    private String[] images;

    private HotelStatus status;

    private Date createdAt;

}
