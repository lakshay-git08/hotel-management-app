package com.app.reactive_programming.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HotelAddressLocation {

    private String type;

    private String[] coordinates;

}
