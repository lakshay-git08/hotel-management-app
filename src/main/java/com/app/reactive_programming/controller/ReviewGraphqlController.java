package com.app.reactive_programming.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Mono<Review> addReview(ReviewInput reviewInput) {
        return reviewService.addReview(reviewInput);
    }

    @MutationMapping
    public Mono<Review> updateReview(String id, ModifyReviewInput modifyReviewInput) {
        return reviewService.updateReview(id, modifyReviewInput);
    }

    @MutationMapping
    public Mono<Boolean> deleteReview(String id) {
        return reviewService.deleteReview(id);
    }
}
