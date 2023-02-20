package com.example.projetfilrougefrontend.controller;


import com.example.projetfilrougefrontend.dto.UserDto;
import com.example.projetfilrougefrontend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
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

    //READ
    @GetMapping
    public ResponseEntity<List<UserDto>> fetchAll() {
        return ResponseEntity.ok(userService.fetchAll());
    }

    //READ
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") Long userId) {
       UserDto userDto = userService.findById(userId);
        if (userDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userDto);
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable("id") Long userId, @RequestBody UserDto userDto) {
        userService.update(userDto, userId);
        return ResponseEntity.ok(userDto);
    }


    //DELETE
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long userId)
    {
        userService.deleteById(userId);
    }

}
