package com.subscriptor.controller;

import com.subscriptor.dto.auth.JwtResponse;
import com.subscriptor.dto.auth.LoginRequest;
import com.subscriptor.dto.user.UserCreateRequest;
import com.subscriptor.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        JwtResponse jwtResponse = authService.login(loginRequest);

        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(@RequestBody @Valid UserCreateRequest userCreateRequest) {
        JwtResponse jwtResponse = authService.register(userCreateRequest);

        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtResponse> refreshToken(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            throw new BadCredentialsException("invalid token");
        }
        JwtResponse jwtResponse = authService.refresh(authHeader);

        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            throw new BadCredentialsException("invalid token");
        }
        authService.logout(authHeader);

        return ResponseEntity.ok("logged out successfully");
    }
}
