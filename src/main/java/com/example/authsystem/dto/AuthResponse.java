package com.example.authsystem.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AuthResponse {
    public String token;

    public AuthResponse(String token) {
        this.token = token;
    }
}