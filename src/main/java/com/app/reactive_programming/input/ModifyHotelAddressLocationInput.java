package com.app.reactive_programming.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ModifyHotelAddressLocationInput {

    private String type;

    private String[] coordinates;

}
