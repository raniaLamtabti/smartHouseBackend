package com.backend.smartHouse.repositories;

import com.backend.smartHouse.entities.House;
import com.backend.smartHouse.entities.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends MongoRepository<House, String> {
    List<House> findByUserId(String Id);
}