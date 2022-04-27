package com.backend.smartHouse.services;

import com.backend.smartHouse.entities.House;
import com.backend.smartHouse.repositories.HouseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class HouseServiceTest {

    @InjectMocks
    HouseService houseService;

    @Mock
    HouseRepository houseRepository;

    House house = new House("eerr","house","address","heftzqeuiqrlige");

    @Test
    void findAll() {
        List<House> devices = List.of(house);
        when(houseRepository.findAll()).thenReturn(devices);
        assertEquals(devices, houseService.findAll());
    }

    @Test
    void getHousesUser() {
    }

    @Test
    void storeHouse() {
        when(houseRepository.save(house)).thenReturn(house);
        assertEquals(house, houseService.storeHouse(house));
    }

    @Test
    void updateHouse() {
        Mockito.lenient().when(houseRepository.findById(house.getId())).thenReturn(Optional.of(house));
        when(houseRepository.save(house)).thenReturn(house);
        assertEquals(house, houseService.updateHouse(house.getId(), house));
    }

    @Test
    void destroyHouse() {
    }
}