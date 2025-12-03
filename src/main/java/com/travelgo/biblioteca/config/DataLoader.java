package com.travelgo.biblioteca.config;

import com.travelgo.biblioteca.model.Role;
import com.travelgo.biblioteca.model.User;
import com.travelgo.biblioteca.repository.RoleRepository;
import com.travelgo.biblioteca.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner initData(UserRepository userRepository,
                                      RoleRepository roleRepository,
                                      PasswordEncoder passwordEncoder) {
        return args -> {
            if (roleRepository.findByName("ROLE_ADMIN").isEmpty()) {
                roleRepository.save(new Role("ROLE_ADMIN"));
            }

            Role adminRole = roleRepository.findByName("ROLE_ADMIN").get();

            if (!userRepository.existsByEmail("admin@travelgo.cl")) {
                User admin = new User();
                admin.setEmail("admin@travelgo.cl");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setEnabled(true);
                admin.addRole(adminRole);
                userRepository.save(admin);
            }
        };
    }
}
