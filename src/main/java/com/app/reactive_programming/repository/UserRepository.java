package com.app.reactive_programming.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.app.reactive_programming.entity.User;

import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

    @Query(" {$or:[ {isDeleted: false}, {isDeleted: {$exists: false} } ]} ")
    public Flux<User> findAllUsers();
}
