package com.generali.userauthservice.user;

import lombok.Getter;

@Getter
public enum UserPermission {
    USER_AUTH_SERVICE_READ("user-auth-service:read"),
    USER_AUTH_SERVICE_WRITE("user-auth-service:write"),
    APP1_READ("app1:read"),
    APP1_WRITE("app1:write"),
    APP2_READ("app2:read"),
    APP2_WRITE("app2:write");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }
}
