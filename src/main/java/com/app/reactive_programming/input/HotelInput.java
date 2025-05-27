package com.app.reactive_programming.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class HotelInput {

    private String name;

    private String description;

    private HotelAddressInput address;

    private String[] amenities;

    private String[] images;

}
