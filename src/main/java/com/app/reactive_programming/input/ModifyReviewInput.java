package com.app.reactive_programming.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ModifyReviewInput {

    private Float rating;

    private String comment;

}
