package com.app.reactive_programming.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HotelInput {

    private String name;

    private String description;

    private HotelAddressInput address;

    private String[] amenities;

    private String[] images;

}
