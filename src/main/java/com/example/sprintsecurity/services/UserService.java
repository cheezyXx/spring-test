package com.example.sprintsecurity.services;

import com.example.sprintsecurity.Entities.Role;
import com.example.sprintsecurity.Entities.User;
import com.example.sprintsecurity.Repositories.RoleRepository;
import com.example.sprintsecurity.Repositories.UserRepository;
import com.example.sprintsecurity.forms.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User saveUser(RegisterForm registerForm) {
        User user = new User();

        user.setEmail(registerForm.getEmail());
        user.setActive(true);
        user.setFirstName(registerForm.getFirstName());
        user.setLastName(registerForm.getLastName());
        user.setPassword(passwordEncoder.encode(registerForm.getPassword()));

        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Collections.singletonList(userRole)));
        return userRepository.save(user);
    }

}