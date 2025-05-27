package com.app.reactive_programming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.app.reactive_programming.entity.User;
import com.app.reactive_programming.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @QueryMapping
    public Flux<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @QueryMapping
    public Mono<User> getUserById(@Argument String id) {
        return userService.getUserById(id);
    }

    @MutationMapping
    public Mono<Boolean> deleteUser(@Argument String id) {
        return userService.deleteUser(id);
    }

}
