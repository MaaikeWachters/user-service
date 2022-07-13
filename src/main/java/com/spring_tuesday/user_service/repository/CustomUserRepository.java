package com.spring_tuesday.user_service.repository;

import com.spring_tuesday.user_service.model.UserEntity;

public interface CustomUserRepository {
    UserEntity customFind (Long id);
    UserEntity customFindByUserName (String username);
}
