package com.app.reactive_programming.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModifyHotelAddressLocationInput {

    private String type;

    private String[] coordinates;

}
