package com.app.reactive_programming.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.reactive_programming.entity.Room;
import com.app.reactive_programming.input.RoomInput;
import com.app.reactive_programming.repository.RoomRepository;
import com.app.reactive_programming.service.RoomService;

import reactor.core.publisher.Mono;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Mono<Room> addRoomToHotel(String hotelId, RoomInput roomInput) {
        Room newRoom = modelMapper.map(roomInput, Room.class);
        newRoom.setHotelId(hotelId);
        return roomRepository.save(newRoom);
    }

    @Override
    public Mono<Room> updateRoom(String id, RoomInput roomInput) {
        return roomRepository.findById(id)
                .flatMap(existingRoom -> {
                    existingRoom.setType(roomInput.getType());
                    existingRoom.setPrice(roomInput.getPrice());
                    existingRoom.setTotalRooms(roomInput.getTotalRooms());
                    return roomRepository.save(existingRoom);
                });
    }

    @Override
    public Mono<Boolean> deleteRoom(String id) {
        Mono<Room> roomFromDB = roomRepository.findById(id);
        if (roomFromDB != null) {
            roomRepository.deleteById(id);
            return Mono.just(true);
        }
        return Mono.just(false);
    }
}
