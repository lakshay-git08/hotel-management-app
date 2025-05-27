package com.app.reactive_programming.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.app.reactive_programming.entity.Hotel;
import com.app.reactive_programming.entity.Room;
import com.app.reactive_programming.service.HotelService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Controller
@Slf4j
public class RoomResolver {

    @Autowired
    HotelService hotelService;

    @SchemaMapping(typeName = "Room", field = "hotel")
    public Mono<Hotel> getHotel(Room room) {
        log.info("Control inside RoomQueryResolver.getHotel()");
        return hotelService.getHotelById(room.getHotelId());
    }
}
