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

    @Override
    public Mono<Review> addReview(ReviewInput reviewInput) {
        Review newReview = modelMapper.map(reviewInput, Review.class);
        newReview.setUserId(newReview.getUserId());
        newReview.setHotelId(newReview.getHotelId());
        newReview.setComment(newReview.getComment());
        newReview.setCreatedAt(new Date());
        newReview.setUpdatedAt(new Date());
        newReview.setDeleted(false);
        newReview.setActive(true);
        return reviewRepository.save(newReview);
    }

    @Override
    public Mono<Review> updateReview(String id, ModifyReviewInput modifyReviewInput) {

        return reviewRepository.findById(id).flatMap(existingReview -> {
            existingReview.setRating(existingReview.getRating());
            existingReview.setComment(existingReview.getComment());
            existingReview.setUpdatedAt(new Date());
            return reviewRepository.save(existingReview);
        });

    }

    @Override
    public Mono<Boolean> deleteReview(String id) {
        return reviewRepository.findById(id).flatMap(review -> {
            review.setDeleted(true);
            return reviewRepository.save(review).then(Mono.just(true));
        }).switchIfEmpty(Mono.just(false));
    }

}
