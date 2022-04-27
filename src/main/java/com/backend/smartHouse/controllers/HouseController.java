package com.backend.smartHouse.controllers;

import com.backend.smartHouse.entities.Floor;
import com.backend.smartHouse.entities.House;
import com.backend.smartHouse.repositories.HouseRepository;
import com.backend.smartHouse.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HouseController {

    @Autowired
    private HouseService houseService;

    @GetMapping("/house")
    public List<House> getAllHouse(){
        return houseService.findAll();
    }

    @PostMapping("/house")
    public House createHouse(@RequestBody House house){
        System.out.println("house data " + house);
        return houseService.storeHouse(house);
    }

    @GetMapping("/house/user/{id}")
    public List<House> getAllUserHouse(@PathVariable String id) {
        return houseService.getHousesUser(id);
    }

    @PutMapping("/house/{id}")
    public House updateHouse(@PathVariable String id, @RequestBody House house) {
        return houseService.updateHouse(id,house);
    }

    @DeleteMapping("/house/{id}")
    public void deleteHouse(@PathVariable String id){
        houseService.destroyHouse(id);
    }
}
