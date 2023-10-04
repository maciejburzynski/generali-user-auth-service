package com.generali.userauthservice.user;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.generali.userauthservice.user.UserPermission.*;

public enum UserRole {

    SUPER_ADMIN(Set.of(USER_AUTH_SERVICE_READ, USER_AUTH_SERVICE_WRITE, APP1_READ, APP1_WRITE, APP2_READ, APP2_WRITE)),
    ADMIN(Set.of(APP1_READ, APP1_WRITE, APP2_READ, APP2_WRITE)),
    USER(Set.of());

    Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    List<SimpleGrantedAuthority> getGrantedAuthorities() {
        List<SimpleGrantedAuthority> authorities = permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return authorities;
    }
}
