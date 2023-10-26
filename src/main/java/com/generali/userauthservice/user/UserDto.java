package com.generali.userauthservice.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {

    @NotBlank(message = "Username must not be blank")
    private String username;
    @NotBlank(message = "Username must not be blank")
    private String password;
}
