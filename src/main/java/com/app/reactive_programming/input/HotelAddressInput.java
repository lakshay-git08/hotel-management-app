package com.app.reactive_programming.input;

import com.app.reactive_programming.entity.HotelAddressLocation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class HotelAddressInput {

    private String street;

    private String city;

    private String state;

    private String zipCode;

    private HotelAddressLocation location;

}
