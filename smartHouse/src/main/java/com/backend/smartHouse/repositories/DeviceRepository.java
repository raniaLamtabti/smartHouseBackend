package com.backend.smartHouse.repositories;

import com.backend.smartHouse.entities.Device;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends MongoRepository<Device, String> {
    List<Device> findByRoomId(String Id);
}

