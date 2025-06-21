package org.wellcare.bootstrap;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.wellcare.model.Role;
import org.wellcare.model.User;
import org.wellcare.repository.UserRepository;

import jakarta.transaction.Transactional;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) {
        if (userRepository.findByUsername("testuser").isEmpty()) {
            User user = new User();
            user.setUsername("testuser");
            user.setPassword(passwordEncoder.encode("testpassword")); // encode password
            user.setRoles(Set.of(Role.ROLE_DOCTOR)); // enum-based roles
            userRepository.save(user);
        }
    }
}
