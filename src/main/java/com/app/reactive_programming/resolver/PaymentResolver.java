package com.app.reactive_programming.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.app.reactive_programming.entity.Booking;
import com.app.reactive_programming.entity.Hotel;
import com.app.reactive_programming.entity.Payment;
import com.app.reactive_programming.entity.User;
import com.app.reactive_programming.service.BookingService;
import com.app.reactive_programming.service.HotelService;
import com.app.reactive_programming.service.UserService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Controller
@Slf4j
public class PaymentResolver {

    @Autowired
    UserService userService;

    @Autowired
    HotelService hotelService;

    @Autowired
    BookingService bookingService;

    @SchemaMapping(typeName = "Payment", field = "user")
    public Mono<User> getUser(Payment payment) {
        log.info("Control inside PaymentQueryResolver.getUser()");
        return userService.getUserById(payment.getUserId());
    }

    @SchemaMapping(typeName = "Payment", field = "hotel")
    public Mono<Hotel> getHotel(Payment payment) {
        log.info("Control inside PaymentQueryResolver.getHotel()");
        return hotelService.getHotelById(payment.getHotelId());
    }

    @SchemaMapping(typeName = "Payment", field = "booking")
    public Mono<Booking> getBooking(Payment payment) {
        log.info("Control inside PaymentQueryResolver.getBooking()");
        return bookingService.getBookingById(payment.getBookingId());
    }

}
