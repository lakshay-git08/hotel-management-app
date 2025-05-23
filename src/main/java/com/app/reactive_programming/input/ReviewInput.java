package com.app.reactive_programming.input;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReviewInput {

    private String userId;

    private String hotelId;

    private Float rating;

    private String comment;
}
