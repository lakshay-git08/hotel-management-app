package com.app.reactive_programming.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.app.reactive_programming.entity.Booking;
import com.app.reactive_programming.entity.Hotel;
import com.app.reactive_programming.entity.Room;
import com.app.reactive_programming.entity.User;
import com.app.reactive_programming.service.HotelService;
import com.app.reactive_programming.service.RoomService;
import com.app.reactive_programming.service.UserService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Controller
@Slf4j
public class BookingResolver {

    @Autowired
    UserService userService;

    @Autowired
    HotelService hotelService;

    @Autowired
    RoomService roomService;

    @SchemaMapping(typeName = "Booking", field = "user")
    public Mono<User> getUser(Booking booking) {
        log.info("Control inside BookingResolver.getUser()");
        return userService.getUserById(booking.getId());
    }

    @SchemaMapping(typeName = "Booking", field = "hotel")
    public Mono<Hotel> getHotel(Booking booking) {
        log.info("Control inside BookingResolver.getHotel()");
        return hotelService.getHotelById(booking.getId());
    }

    @SchemaMapping(typeName = "Booking", field = "room")
    public Mono<Room> getRoom(Booking booking) {
        log.info("Control inside BookingResolver.getRoom()");
        return roomService.getRoomById(booking.getId());
    }

}

// userId: String!
// hotelId: String!
// roomId: String!