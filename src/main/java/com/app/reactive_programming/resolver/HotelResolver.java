package com.app.reactive_programming.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.app.reactive_programming.entity.Hotel;
import com.app.reactive_programming.entity.User;
import com.app.reactive_programming.service.UserService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Controller
@Slf4j
public class HotelResolver {

    @Autowired
    UserService userService;

    @SchemaMapping(typeName = "Hotel", field = "user")
    public Mono<User> getUser(Hotel hotel) {
        log.info("Control inside HotelResolver.getUser()");
        return userService.getUserById(hotel.getId());
    }
}
