package com.app.reactive_programming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.app.reactive_programming.entity.User;
import com.app.reactive_programming.input.LoginInput;
import com.app.reactive_programming.input.RegisterInput;
import com.app.reactive_programming.service.AuthService;

import reactor.core.publisher.Mono;

@Controller
public class AuthGraphqlController {

    @Autowired
    AuthService authService;

    @MutationMapping
    public Mono<User> registerUser(@Argument RegisterInput input) {
        return authService.registerUser(input);
    }

    @MutationMapping
    public Mono<User> registerOwner(@Argument RegisterInput input) {
        return authService.registerOwner(input);
    }

    @MutationMapping
    public Mono<User> loginUser(@Argument LoginInput LoginInput) {
        return authService.loginUser(LoginInput);
    }
}

// getBookingDetails by bookingID
// userId, bookingID, hotelID
// createdAt, updatedAt set
// register API
// manually test -> hotel, room, user, booking, payment, review
// pending API complete
