package com.app.reactive_programming.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModifyReviewInput {

    private Float rating;

    private String comment;

}
