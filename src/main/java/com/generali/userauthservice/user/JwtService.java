package com.generali.userauthservice.user;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {


    private final AuthenticationManager authenticationManager;

    @Value("${jwt.user-service.key:dupa}")
    private String KEY;

    UserLoginResponse validateUserAndGenerateToken(UserLoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()));

        User user = (User) authentication.getPrincipal();

        String[] permissions = user.getUserRole().getGrantedAuthorities()
                .stream()
                .map(permission -> permission.getAuthority()).toArray(value -> new String[value]);

        Algorithm algorithm = Algorithm.HMAC256(KEY);
        String token = JWT.create()
                .withSubject(user.getUsername())
                .withArrayClaim("permissions", permissions)
                .withExpiresAt(new Date(System.currentTimeMillis() + (10 * 60 * 1000))) // 10 minutes
                .sign(algorithm);

        return new UserLoginResponse(token, null);
    }
}
