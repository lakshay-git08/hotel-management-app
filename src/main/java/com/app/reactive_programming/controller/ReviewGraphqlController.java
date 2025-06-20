package com.app.reactive_programming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.app.reactive_programming.entity.Review;
import com.app.reactive_programming.input.ModifyReviewInput;
import com.app.reactive_programming.input.ReviewInput;
import com.app.reactive_programming.service.ReviewService;

import reactor.core.publisher.Mono;

@Controller
public class ReviewGraphqlController {

    @Autowired
    ReviewService reviewService;

    @MutationMapping
    public Mono<Review> addReview(@Argument ReviewInput input) {
        return reviewService.addReview(input);
    }

    @MutationMapping
    public Mono<Review> updateReview(@Argument String id, @Argument ModifyReviewInput input) {
        return reviewService.updateReview(id, input);
    }

    @MutationMapping
    public Mono<Boolean> deleteReview(@Argument String id) {
        return reviewService.deleteReview(id);
    }
}
