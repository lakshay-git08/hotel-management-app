package com.app.reactive_programming.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.app.reactive_programming.entity.Hotel;
import com.app.reactive_programming.entity.Review;
import com.app.reactive_programming.entity.User;
import com.app.reactive_programming.service.HotelService;
import com.app.reactive_programming.service.UserService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Controller
@Slf4j
public class ReviewResolver {

    @Autowired
    UserService userService;

    @Autowired
    HotelService hotelService;

    @SchemaMapping(typeName = "Review", field = "user")
    public Mono<User> getUser(Review review) {
        log.info("Control inside ReviewQueryResolver.getUser()");
        return userService.getUserById(review.getUserId());
    }

    @SchemaMapping(typeName = "Review", field = "hotel")
    public Mono<Hotel> getHotel(Review review) {
        log.info("Control inside ReviewQueryResolver.getHotel()");
        return hotelService.getHotelById(review.getHotelId());
    }
}

// private String userId;

// private String hotelId;