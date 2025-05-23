package com.app.reactive_programming.input;

import com.app.reactive_programming.entity.HotelAddress;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModifyHotelInput {

    private String name;

    private String description;

    private HotelAddress address;

    private String[] amenities;

    private String[] images;

}
