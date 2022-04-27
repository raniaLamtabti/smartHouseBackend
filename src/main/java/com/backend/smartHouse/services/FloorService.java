package com.backend.smartHouse.services;

import com.backend.smartHouse.entities.Floor;
import com.backend.smartHouse.entities.House;
import com.backend.smartHouse.entities.Room;
import com.backend.smartHouse.repositories.FloorRepository;
import com.backend.smartHouse.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FloorService {

    @Autowired
    private FloorRepository floorRepository;

    public List<Floor> findAll() {
        return floorRepository.findAll();
    }

    public Floor storeFloor(Floor floor) {
        return floorRepository.save(floor);
    }

    public List<Floor> getHouseFloors(String id) {
        return floorRepository.findByHouseId(id);
    }

    public Floor updateFloor(String id, Floor floor) {
        Optional<Floor> floor1 = floorRepository.findById(id);

        if(floor1.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        floor1.get().setHouseId(floor.getHouseId());
        floor1.get().setNumber(floor.getNumber());
        return floorRepository.save(floor1.get());
    }

    public void destroyFloor(String id) {
        Optional<Floor> floor = floorRepository.findById(id);
        floor.ifPresent(value -> floorRepository.delete(value));
    }
}
