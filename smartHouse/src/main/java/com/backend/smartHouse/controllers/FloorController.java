package com.backend.smartHouse.controllers;

import com.backend.smartHouse.entities.Floor;
import com.backend.smartHouse.entities.House;
import com.backend.smartHouse.entities.Room;
import com.backend.smartHouse.services.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FloorController {

    @Autowired
    private FloorService floorService;

    @GetMapping("/floor")
    public List<Floor> getAllFloor(){
        return floorService.findAll();
    }

    @PostMapping("/floor")
    public Floor createFloor(@RequestBody Floor floor){
        System.out.println("floor data " + floor);
        return floorService.storeFloor(floor);
    }

    @GetMapping("/floor/house/{id}")
    public List<Floor> getAllHouseFloor(@PathVariable String id) {
        return floorService.getHouseFloors(id);
    }

    @PutMapping("/floor/{id}")
    public Floor editFloor(@PathVariable String id, @RequestBody Floor floor) {
        return floorService.updateFloor(id,floor);
    }

    @DeleteMapping("/floor/{id}")
    public void deleteFloor(@PathVariable String id){
        floorService.destroyFloor(id);
    }
}