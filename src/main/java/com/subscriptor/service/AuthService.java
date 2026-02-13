package com.subscriptor.service;

import com.subscriptor.dto.JwtResponse;
import com.subscriptor.dto.auth.LoginRequest;
import com.subscriptor.dto.user.UserCreateRequest;
import com.subscriptor.entity.user.User;
import com.subscriptor.mapper.UserMapper;
import com.subscriptor.repository.UserRepository;
import com.subscriptor.security.CustomUserDetailsService;
import com.subscriptor.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthService {
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;
    private final CustomUserDetailsService customUserDetailsService;

    private final ArrayList<String> tokenBlackList = new ArrayList<>();
    private final UserRepository userRepository;

    public AuthService(UserService userService, JwtService jwtService, AuthenticationManager authenticationManager, UserMapper userMapper, CustomUserDetailsService customUserDetailsService, UserRepository userRepository) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userMapper = userMapper;
        this.customUserDetailsService = customUserDetailsService;
        this.userRepository = userRepository;
    }

    public JwtResponse register(UserCreateRequest userCreateRequest) {
        return login(userMapper.toLoginRequest(userService.createUser(userCreateRequest)));
    }

    public JwtResponse login(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequest.getEmail(),
                    loginRequest.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            User userDetails = (User) customUserDetailsService.loadUserByUsername(loginRequest.getEmail());
            String token = jwtService.generateToken(userDetails);

            return new JwtResponse(
                    token,
                    "Bearer",
                    userDetails.getId()
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(e.getMessage());
        }
    }

    public JwtResponse refresh(String oldToken) {
        if (tokenBlackList.contains(oldToken)) {
            throw new BadCredentialsException(oldToken);
        }

        String email = jwtService.extractUserEmail(oldToken);

        if (email == null) {
            throw new BadCredentialsException("invalid token");
        }

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);

        if(!jwtService.isTokenValid(oldToken, userDetails)) {
            throw new BadCredentialsException("invalid token");
        }

        tokenBlackList.add(oldToken);

        String newToken = jwtService.generateToken(userDetails);

        User user = userRepository.findByEmail(email).orElse(null);

        assert user != null;
        return new JwtResponse(
                newToken,
                "bearer",
                user.getId()
        );
    }

    public void logout(String token) {
        tokenBlackList.add(token);
        SecurityContextHolder.clearContext();
    }
}
