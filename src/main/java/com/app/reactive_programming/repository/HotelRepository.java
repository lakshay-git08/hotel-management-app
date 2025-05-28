package com.app.reactive_programming.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.app.reactive_programming.entity.Hotel;

import reactor.core.publisher.Flux;

@Repository
public interface HotelRepository extends ReactiveMongoRepository<Hotel, String> {

    @Query(" {$or:[ {isDeleted: false}, {isDeleted: {$exists: false} } ]} ")
    public Flux<Hotel> findAllHotels();

}
