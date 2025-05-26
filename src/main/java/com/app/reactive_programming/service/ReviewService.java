package com.app.reactive_programming.service;

import com.app.reactive_programming.entity.Review;
import com.app.reactive_programming.input.ModifyReviewInput;
import com.app.reactive_programming.input.ReviewInput;

import reactor.core.publisher.Mono;

public interface ReviewService {

    public Mono<Review> addReview(ReviewInput reviewInput);

    public Mono<Review> updateReview(String id, ModifyReviewInput reviewInput);

    public Mono<Boolean> deleteReview(String id);

}
