package com.generali.userauthservice.user;

import lombok.Data;

@Data
public class UpdateUserRequest {

    private String username;
    private String password;

}
