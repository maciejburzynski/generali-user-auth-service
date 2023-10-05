package com.generali.userauthservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.*;

@Data
@AllArgsConstructor
public class UserLoginResponse {

    @JsonInclude(Include.NON_NULL)
    private String token;
    @JsonInclude(Include.NON_NULL)
    private String exception;
}
