package com.backend.smartHouse.services;

import com.backend.smartHouse.entities.Device;
import com.backend.smartHouse.entities.Floor;
import com.backend.smartHouse.repositories.DeviceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {
    DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Device storeDevice(Device device) {
        return deviceRepository.save(device);
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public List<Device> getRoomDevices(String id) {
        return deviceRepository.findByRoomId(id);
    }

    public Device updateDevice(String id, Device device) {
        Optional<Device> found = deviceRepository.findById(id);

        if(found.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        found.get().setName(device.getName());
        found.get().setStatus(device.getStatus());
        found.get().setRoomId(device.getRoomId());
        return deviceRepository.save(found.get());
    }

    public void destroyDevice(String id) {
        Optional<Device> device = deviceRepository.findById(id);
        device.ifPresent(value -> deviceRepository.delete(value));
    }
}
