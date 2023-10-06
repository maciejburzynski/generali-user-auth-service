package com.generali.userauthservice.user;

import lombok.Getter;

@Getter
public enum UserPermission {
    USER_AUTH_SERVICE_READ("user-auth-service:read"),
    USER_AUTH_SERVICE_WRITE("user-auth-service:write"),
    MAIL_SERVICE_READ("mail-service:read"),
    MAIL_SERVICE_WRITE("mail-service:write"),
    APP2_READ("app2:read"),
    APP2_WRITE("app2:write");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }
}
