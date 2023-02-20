package com.example.projetfilrougefrontend.service;

import com.example.projetfilrougefrontend.dto.UserDto;
import com.example.projetfilrougefrontend.entity.User;
import com.example.projetfilrougefrontend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public void save(UserDto userDto) {
        User user = userDto.toEntity();
        userRepository.save(user);
    }


    public List<UserDto> fetchAll() {
        //
        return userRepository.findAll()
                .stream()
                .map(user -> user.toDto())
                .collect(Collectors.toList());
    }

    public UserDto findById(Long userId){

        Optional<User> user = userRepository.findById(userId);
        return (user.get()).toDto();
    }

    public void deleteById(Long userId)
    {
        userRepository.deleteById(userId);
    }

    public  void update(UserDto userDto, Long userId) {

        User user = userDto.toEntity();
        Optional<User> userToUpdate = userRepository.findById(userId);
        if (userToUpdate.isPresent())
        {
            user.setId(userToUpdate.get().getId());
            userRepository.save(user);
        }
    }





}
