package com.backend.smartHouse.services;

import com.backend.smartHouse.entities.Floor;
import com.backend.smartHouse.entities.House;
import com.backend.smartHouse.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService {

    @Autowired
    private HouseRepository houseRepository;

    public List<House> findAll() {
        return houseRepository.findAll();
    }

    public List<House> getHousesUser(String id) {
        return houseRepository.findByUserId(id);
    }

    public House storeHouse(House house) {
        return houseRepository.save(house);
    }

    public House updateHouse(String id,House house) {
        Optional<House> found = houseRepository.findById(id);

        if(found.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        found.get().setName(house.getName());
        found.get().setAddress(house.getAddress());
        found.get().setUserId(house.getUserId());
        return houseRepository.save(found.get());
    }

    public void destroyHouse(String id) {
        Optional<House> house = houseRepository.findById(id);
        house.ifPresent(value -> houseRepository.delete(value));
    }
}

