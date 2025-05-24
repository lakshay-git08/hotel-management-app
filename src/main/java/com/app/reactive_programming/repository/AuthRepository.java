package com.app.reactive_programming.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.app.reactive_programming.entity.User;

public interface AuthRepository extends ReactiveMongoRepository<User, String> {

}
