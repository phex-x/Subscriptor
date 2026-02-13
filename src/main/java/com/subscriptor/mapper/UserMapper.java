package com.subscriptor.mapper;

import com.subscriptor.dto.auth.LoginRequest;
import com.subscriptor.dto.user.UserCreateRequest;
import com.subscriptor.dto.user.UserResponse;
import com.subscriptor.entity.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserCreateRequest userCreateRequest) {
        User user = new User();
        user.setEmail(userCreateRequest.getEmail());
        user.setFirstName(userCreateRequest.getFirstName());
        user.setLastName(userCreateRequest.getLastName());
        user.setPasswordHash(userCreateRequest.getPassword()); //todo password encoder

        return user;
    }

    public UserResponse toResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setRole(user.getRole());

        return userResponse;
    }

    public LoginRequest toLoginRequest(UserResponse userResponse) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(userResponse.getEmail());
        loginRequest.setPassword(userResponse.getFirstName());

        return loginRequest;
    }
}
