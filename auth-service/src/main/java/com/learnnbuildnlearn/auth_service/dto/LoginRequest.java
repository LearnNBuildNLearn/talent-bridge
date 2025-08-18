package com.learnnbuildnlearn.auth_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    @NotBlank(message = "email cannot be blank")
    @Email(message = "invalid email format")
    private String email;

    @NotBlank(message = "password cannot be blank")
    @Size(min = 8, message = "password should be at least 8 character long")
    private String password;
}
