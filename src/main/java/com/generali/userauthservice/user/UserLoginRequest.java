package com.generali.userauthservice.user;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String Username;
    private String Password;
}
