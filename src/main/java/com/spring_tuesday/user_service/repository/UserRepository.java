package com.spring_tuesday.user_service.repository;

import com.spring_tuesday.user_service.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, CustomUserRepository {

}
