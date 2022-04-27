package com.backend.smartHouse.services;

import com.backend.smartHouse.entities.House;
import com.backend.smartHouse.entities.Room;
import com.backend.smartHouse.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    public List<Room> getFloorRooms(String id) {
        return roomRepository.findByFloorId(id);
    }

    public Room storeRoom(Room room) {
        System.out.println(room);
        return roomRepository.save(room);
    }

    public Room updateRoom(String id,Room room) {
        Optional<Room> found = roomRepository.findById(id);

        if(found.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        found.get().setName(room.getName());
        found.get().setFloorId(room.getFloorId());
        return roomRepository.save(found.get());
    }

    public void destroyRoom(String id) {
        Optional<Room> room = roomRepository.findById(id);
        room.ifPresent(value -> roomRepository.delete(value));
    }
}