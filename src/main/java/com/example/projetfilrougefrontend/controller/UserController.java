package com.example.projetfilrougefrontend.controller;


import com.example.projetfilrougefrontend.dto.UserDto;
import com.example.projetfilrougefrontend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
public class UserController {

    @Autowired
    public UserService userService;


    //CRUD

    //CREATE
    @PostMapping("/add")
    ResponseEntity<UserDto> newUser(@RequestBody UserDto newUser) {

        userService.save(newUser);

        return ResponseEntity //
                .ok()
                .body(newUser);
    }

    //READ - GET ALL USERS
    @GetMapping
    public ResponseEntity<List<UserDto>> fetchAll() {
        return ResponseEntity.ok(userService.fetchAll());
    }

    //READ - GET USER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") Long userId) {
        UserDto userDto = userService.findById(userId);
        if (userDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userDto);
    }

    //UPDATE BY ID
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable("id") Long userId, @RequestBody UserDto userDto) {
        userService.update(userDto, userId);
        return ResponseEntity.ok(userDto);
    }


    //DELETE BY ID
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long userId) {
        userService.deleteById(userId);
    }

}
