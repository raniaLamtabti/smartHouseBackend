package com.backend.smartHouse.controllers;

import com.backend.smartHouse.entities.User;
import com.backend.smartHouse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.storeUser(user);
    }

    @GetMapping("/user")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable String id){
        return userService.findUser(id);
    }


    @PutMapping("/user/{id}")
    public User updateProfile(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteHouse(@PathVariable String id){
        userService.destroyUser(id);
    }
}
