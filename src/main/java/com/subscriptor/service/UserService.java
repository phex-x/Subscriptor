package com.subscriptor.service;

import com.subscriptor.dto.user.UserCreateRequest;
import com.subscriptor.dto.user.UserResponse;
import com.subscriptor.entity.user.User;
import com.subscriptor.entity.user.UserRole;
import com.subscriptor.mapper.UserMapper;
import com.subscriptor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserResponse createUser(UserCreateRequest userCreateRequest) {
        if (userRepository.findByEmail(userCreateRequest.getEmail()).isPresent()) {
            throw new BadCredentialsException("Email already exists");
        }
        User user = userMapper.toEntity(userCreateRequest);
        user = userRepository.save(user);

        return userMapper.toResponse(user);
    }

    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new BadCredentialsException("user not found"));

        return userMapper.toResponse(user);
    }

    public UserResponse changeRole(Long id, UserRole role) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new BadCredentialsException("user not found"));

        user.setRole(role);
        user = userRepository.save(user);

        return userMapper.toResponse(user);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new BadCredentialsException("user not found"));

        userRepository.delete(user);
    }

}
