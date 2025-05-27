package com.app.reactive_programming.serviceImpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.reactive_programming.entity.Room;
import com.app.reactive_programming.input.ModifyRoomInput;
import com.app.reactive_programming.input.RoomInput;
import com.app.reactive_programming.repository.RoomRepository;
import com.app.reactive_programming.service.RoomService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Flux<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Mono<Room> getRoomById(String id) {
        return roomRepository.findById(id);
    }

    @Override
    public Mono<Room> addRoomToHotel(String hotelId, RoomInput roomInput) {
        Room newRoom = modelMapper.map(roomInput, Room.class);
        newRoom.setHotelId(hotelId);
        newRoom.setCreatedAt(new Date());
        newRoom.setUpdatedAt(new Date());
        return roomRepository.save(newRoom);
    }

    @Override
    public Mono<Room> updateRoom(String id, ModifyRoomInput modifyRoomInput) {
        return roomRepository.findById(id)
                .flatMap(existingRoom -> {
                    existingRoom.setType(modifyRoomInput.getType());
                    existingRoom.setPrice(modifyRoomInput.getPrice());
                    existingRoom.setTotalRooms(modifyRoomInput.getTotalRooms());
                    existingRoom.setUpdatedAt(new Date());
                    return roomRepository.save(existingRoom);
                });
    }

    @Override
    public Mono<Boolean> deleteRoom(String id) {
        return roomRepository.findById(id).flatMap(room -> {
            if (room != null) {
                roomRepository.deleteById(id);
                room.setUpdatedAt(new Date());
                return Mono.just(true);
            }
            return Mono.just(false);
        });
    }
}
