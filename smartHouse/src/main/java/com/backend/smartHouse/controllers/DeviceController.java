package com.backend.smartHouse.controllers;

import com.backend.smartHouse.entities.Device;
import com.backend.smartHouse.entities.Room;
import com.backend.smartHouse.services.DeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeviceController {

    DeviceService deviceService;

    DeviceController(DeviceService deviceService){
        this.deviceService = deviceService;
    }

    @GetMapping("/device")
    public List<Device> getAllDevices(){
        return deviceService.getAllDevices();
    }

    @GetMapping("/device/room/{id}")
    public List<Device> getAllRoomDevices(@PathVariable String id) {
        return deviceService.getRoomDevices(id);
    }

    @PostMapping("/device")
    public Device createDevice(@RequestBody Device device){
        return deviceService.storeDevice(device);
    }

    @PutMapping("/device/{id}")
    public Device editDevice(@PathVariable String id, @RequestBody Device device){
        return deviceService.updateDevice(id,device);
    }

    @DeleteMapping("/device/{id}")
    public void deleteDevice(@PathVariable String id){
        deviceService.destroyDevice(id);
    }
}
