package com.spring_tuesday.user_service.controller;

import com.spring_tuesday.user_service.model.UserDTO;
import com.spring_tuesday.user_service.model.UserEntity;
import com.spring_tuesday.user_service.repository.UserRepository;
import com.spring_tuesday.user_service.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }


    @GetMapping("/users")
    List<UserDTO> findAll() {
        return userService.findAllUsers();
    }

    @GetMapping("/user/{id}")
    UserDTO findById(@PathVariable Long id) {
        return userService.customFind(id);
    }

    @PostMapping("/user")
    UserDTO save(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @DeleteMapping("/user/{username}")
    void delete(@PathVariable String username) {
        userService.delete(username);
    }



}

