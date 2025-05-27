package com.app.reactive_programming.service;

import com.app.reactive_programming.entity.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    public Flux<User> getAllUsers();

    public Mono<User> getUserById(String id);

}
