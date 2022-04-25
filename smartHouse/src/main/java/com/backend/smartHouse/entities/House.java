package com.backend.smartHouse.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document("houses")
public class House {

    @Id
    private String id;

    private String name;

    private String address;

    private String userId;

    public House(String name, String address, String userId) {
    }
}