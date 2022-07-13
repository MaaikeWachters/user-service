package com.spring_tuesday.user_service.service;

import com.spring_tuesday.user_service.exception.ConstraintViolation;
import com.spring_tuesday.user_service.model.UserDTO;
import com.spring_tuesday.user_service.model.UserEntity;
import com.spring_tuesday.user_service.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        List<UserDTO> usersDTO = users.stream().map(u -> new UserDTO(u.getUsername(), u.getFirstName(), u.getLastName())).collect(Collectors.toList());
        return usersDTO;
    }

    public UserDTO save(UserDTO userDTO) {
        try {
            UserEntity userEntity = new UserEntity(userDTO.getUserName(), userDTO.getFirstName(), userDTO.getLastName());
            userEntity = userRepository.save(userEntity);
            return new UserDTO(userEntity.getUsername(), userEntity.getFirstName(), userEntity.getLastName());

        } catch (Exception e) {
            throw new ConstraintViolation(e.getMessage());
        }
    }

    public void delete(String username) {
        UserEntity userEntity = userRepository.customFindByUserName(username);
        userRepository.deleteById(userEntity.getId());
    }

    public UserDTO customFind(Long id) {
        UserEntity userEntity = userRepository.customFind(id);
        return new UserDTO(userEntity.getUsername(), userEntity.getFirstName(), userEntity.getLastName());
    }



}
