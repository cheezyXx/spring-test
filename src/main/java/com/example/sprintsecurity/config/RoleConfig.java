package com.example.sprintsecurity.config;

import com.example.sprintsecurity.Entities.Role;
import com.example.sprintsecurity.Repositories.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class RoleConfig {

    @Bean
    CommandLineRunner commandLineRunner(RoleRepository roleRepository) {
        return args -> {
            try {
                roleRepository.save(new Role("ADMIN"));
                roleRepository.save(new Role("USER"));
            } catch (Exception e) {
                log.debug(e.getMessage());
            }
        };
    }
}
