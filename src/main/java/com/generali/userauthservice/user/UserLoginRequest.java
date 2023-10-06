package com.generali.userauthservice.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginRequest {

    @NotBlank(message = "Username must not be blank")
    private String Username;
    @NotBlank(message = "Username must not be blank")
    private String Password;
}
