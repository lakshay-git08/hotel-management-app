package com.app.reactive_programming.serviceImpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.reactive_programming.entity.Review;
import com.app.reactive_programming.input.ModifyReviewInput;
import com.app.reactive_programming.input.ReviewInput;
import com.app.reactive_programming.repository.ReviewRepository;
import com.app.reactive_programming.service.ReviewService;

import reactor.core.publisher.Mono;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ModelMapper modelMapper;

    public Mono<Review> addReview(ReviewInput reviewInput) {
        Review newReview = modelMapper.map(reviewInput, Review.class);
        newReview.setUserId(newReview.getUserId());
        newReview.setHotelId(newReview.getHotelId());
        newReview.setComment(newReview.getComment());
        newReview.setCreatedAt(new Date());
        newReview.setUpdatedAt(new Date());
        return reviewRepository.save(newReview);
    }

    public Mono<Review> updateReview(String id, ModifyReviewInput modifyReviewInput) {

        return reviewRepository.findById(id).flatMap(existingReview -> {
            existingReview.setRating(existingReview.getRating());
            existingReview.setComment(existingReview.getComment());
            existingReview.setUpdatedAt(new Date());
            return reviewRepository.save(existingReview);
        });

    }

    public Mono<Boolean> deleteReview(String id) {
        return reviewRepository.findById(id).flatMap(review -> {
            if (review != null) {
                review.setUpdatedAt(new Date());
                reviewRepository.deleteById(id);
                return Mono.just(true);
            }
            return Mono.just(false);
        });

    }

}
