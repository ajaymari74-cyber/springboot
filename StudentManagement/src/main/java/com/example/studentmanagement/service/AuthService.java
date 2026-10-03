package com.example.studentmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.studentmanagement.dto.LoginRequestDTO;
import com.example.studentmanagement.dto.RegisterRequestDTO;
import com.example.studentmanagement.entity.User;
import com.example.studentmanagement.repoitory.UserRepository;
import com.example.studentmanagement.security.JwtService;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String register(RegisterRequestDTO request) {

        if (userRepository.findByUsername(request.getUserName()).isPresent()) {
            return "Username already exists";
        }

        User user = new User();

        user.setUserName(request.getUserName());

        // Password is stored in encrypted form
        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        user.setRole(request.getRole() != null ? request.getRole().toUpperCase() : "STUDENT");

        userRepository.save(user);

        return "User registered successfully";
    }

    public String login(LoginRequestDTO request) {

        User user = userRepository
                .findByUsername(request.getUserName())
                .orElseThrow(() ->
                        new RuntimeException("Invalid username or password"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException("Invalid username or password");
        }

        return jwtService.generateToken(user);
    }

}
