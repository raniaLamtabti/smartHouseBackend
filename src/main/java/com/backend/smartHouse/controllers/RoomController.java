package com.backend.smartHouse.controllers;

import com.backend.smartHouse.entities.Room;
import com.backend.smartHouse.services.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    RoomService roomService;

    RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/room")
    public List<Room> getAllRoom() {
        return roomService.getRooms();
    }

    @GetMapping("/room/floor/{id}")
    public List<Room> getAllFloreRoom(@PathVariable String id) {
        return roomService.getFloorRooms(id);
    }

    @PostMapping("/room")
    public Room createRoom(@RequestBody Room room) {
        return roomService.storeRoom(room);
    }

    @PutMapping("/room/{id}")
    public Room updateRoom(@PathVariable String id, @RequestBody Room room) {
        return roomService.updateRoom(id, room);
    }

    @DeleteMapping("/room/{id}")
    public void deleteRoom(@PathVariable String id) {
        roomService.destroyRoom(id);
    }
}
