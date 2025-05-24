package com.app.reactive_programming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Controller;

import com.app.reactive_programming.entity.User;
import com.app.reactive_programming.input.RegisterInput;
import com.app.reactive_programming.service.AuthService;

import reactor.core.publisher.Mono;

@Controller
public class UserGraphqlController {

    @Autowired
    AuthService authService;

    public Mono<User> registerUser(@Argument RegisterInput registerInput) {
        return authService.registerUser(registerInput);
    }

    public Mono<User> registerOwner(@Argument RegisterInput registerInput) {
        return authService.registerOwner(registerInput);
    }

}
