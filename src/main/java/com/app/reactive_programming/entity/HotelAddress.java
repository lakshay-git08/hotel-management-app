package com.app.reactive_programming.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelAddress {

    private String street;

    private String city;

    private String state;

    private String zipCode;

    private HotelAddressLocation location;

}
