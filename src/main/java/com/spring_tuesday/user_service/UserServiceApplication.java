package com.spring_tuesday.user_service;

import com.spring_tuesday.user_service.model.UserEntity;
import com.spring_tuesday.user_service.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            userRepository.save(new UserEntity("MaaikeW", "Maaike", "Wachters"));
            userRepository.save(new UserEntity("SelmerV", "Selmer", "van Alten"));
        };
    }


}




