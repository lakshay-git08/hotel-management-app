package com.app.reactive_programming.service;

import com.app.reactive_programming.entity.User;
import com.app.reactive_programming.input.LoginInput;
import com.app.reactive_programming.input.RegisterInput;

import reactor.core.publisher.Mono;

public interface AuthService {

    public Mono<User> registerUser(RegisterInput registerInput);

    public Mono<User> registerOwner(RegisterInput registerInput);

    public Mono<User> loginUser(LoginInput LoginInput);

}
