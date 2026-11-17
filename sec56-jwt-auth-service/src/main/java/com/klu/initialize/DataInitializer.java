package com.klu.initialize;

import com.klu.entity.User;
import com.klu.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(UserRepository repository) {

        return args -> {

            if (repository.findByUsername("admin") == null) {
                repository.save(new User("admin", "admin123", "ADMIN"));
            }

            if (repository.findByUsername("venki") == null) {
                repository.save(new User("venki", "venki123", "USER"));
            }

        };
    }
}