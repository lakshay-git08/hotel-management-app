package com.app.reactive_programming.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ReviewInput {

    private String userId;

    private String hotelId;

    private Float rating;

    private String comment;
}
