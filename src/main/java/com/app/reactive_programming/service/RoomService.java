package com.app.reactive_programming.service;

import com.app.reactive_programming.entity.Room;
import com.app.reactive_programming.input.RoomInput;

import reactor.core.publisher.Mono;

public interface RoomService {

    public Mono<Room> addRoomToHotel(String hotelId, RoomInput roomInput);

    public Mono<Room> updateRoom(String id, RoomInput roomInput);

    public Mono<Boolean> deleteRoom(String id);

}
