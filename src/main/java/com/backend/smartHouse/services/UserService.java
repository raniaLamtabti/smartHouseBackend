package com.backend.smartHouse.services;

import com.backend.smartHouse.entities.User;
import com.backend.smartHouse.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User storeUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findUser(String id) {
        return userRepository.findById(id);
    }

    public User updateUser(String id,User user) {
        Optional<User> found = userRepository.findById(id);

        if(found.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        found.get().setEmail(user.getEmail());
        found.get().setUsername(user.getUsername());
        found.get().setPassword(user.getPassword());
        return userRepository.save(found.get());
    }

    public void destroyUser(String id) {
        Optional<User> house = userRepository.findById(id);
        house.ifPresent(value -> userRepository.delete(value));
    }
}


