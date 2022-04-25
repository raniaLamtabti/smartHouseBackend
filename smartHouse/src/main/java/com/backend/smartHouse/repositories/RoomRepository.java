package com.backend.smartHouse.repositories;

import com.backend.smartHouse.entities.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends MongoRepository<Room,String> {
    List<Room> findByFloorId(String Id);
}

