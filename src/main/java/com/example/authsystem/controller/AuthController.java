package com.example.authsystem.controller;

import com.example.authsystem.dto.LoginRequest;
import com.example.authsystem.dto.AuthResponse;
import com.example.authsystem.entity.User;
import com.example.authsystem.repository.UserRepository;
import com.example.authsystem.service.JwtService;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    public AuthController(UserRepository repo,
                          PasswordEncoder encoder,
                          JwtService jwtService,
                          AuthenticationManager authManager) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwtService = jwtService;
        this.authManager = authManager;
    }

    // 🔐 SIGNUP
    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("USER");
        repo.save(user);
        return "User registered";
    }

    // 🔐 LOGIN (CLEAN VERSION)
    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        // 🔥 THIS LINE DOES ALL VALIDATION
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username,
                        request.password
                )
        );

        // If above fails → exception automatically thrown

        String token = jwtService.generateToken(request.username);

        return new AuthResponse(token);
    }
}