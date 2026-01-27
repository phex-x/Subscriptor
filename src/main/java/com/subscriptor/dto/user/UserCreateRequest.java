package com.subscriptor.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserCreateRequest {
    @Email(message = "email must be valid")
    private String email;

    @NotBlank(message = "first name can't be null")
    private String firstName;

    @NotBlank(message = "last name can't be null")
    private String lastName;

    @Size(min = 8, message = "password must be at least 8 symbols")
    private String password;

    @NotBlank(message = "password confirm can't be null")
    private String passwordConfirm;

    //getters
    public String getEmail() { return email; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPassword() { return password; }
    public String getPasswordConfirm() { return passwordConfirm; }

    //setters
    public void setEmail(String email) { this.email = email; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setPassword(String password) { this.password = password; }
    public void setPasswordConfirm(String passwordConfirm) { this.passwordConfirm = passwordConfirm; }
}
