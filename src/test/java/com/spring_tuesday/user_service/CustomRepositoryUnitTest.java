package com.spring_tuesday.user_service;

import com.spring_tuesday.user_service.exception.UserNotFoundException;
import com.spring_tuesday.user_service.model.UserEntity;
import com.spring_tuesday.user_service.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomRepositoryUnitTest {

    @Autowired
    private  UserRepository userRepository;

    @Test
    public void customFindShouldReturnUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("Test UN");
        userEntity.setFirstName("Test FN");
        userEntity.setLastName("Test LN");

        UserEntity savedUser = userRepository.save(userEntity);



        assertNotNull(userRepository.customFind(userEntity.getId()));
        assertEquals(savedUser.getUsername(), userRepository.customFind(userEntity.getId()).getUsername());

    }

    @Test
    public void customFindShouldReturnException() {
        assertThrows(UserNotFoundException.class, () -> userRepository.customFind(110L));

    }
}
