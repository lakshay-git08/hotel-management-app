package com.app.reactive_programming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.app.reactive_programming.entity.Room;
import com.app.reactive_programming.input.RoomInput;
import com.app.reactive_programming.service.RoomService;

import reactor.core.publisher.Mono;

@Controller
public class RoomGraphqlController {

    @Autowired
    RoomService roomService;

    @MutationMapping
    public Mono<Room> addRoomToHotel(@Argument String hotelId, @Argument RoomInput input) {
        return roomService.addRoomToHotel(hotelId, input);
    }

    @MutationMapping
    public Mono<Room> updateRoom(@Argument String id, @Argument RoomInput input) {
        return roomService.updateRoom(id, input);
    }

    @MutationMapping
    public Mono<Boolean> deleteRoom(@Argument String id) {
        return roomService.deleteRoom(id);
    }
}
