package com.generali.userauthservice.user;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwtHeaderOrCookieName = "Authorization";

        if (request.getHeader(jwtHeaderOrCookieName) == null) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = request.getHeader(jwtHeaderOrCookieName).substring(7);

        Algorithm algorithm = Algorithm.HMAC256("key-generali");
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        String[] permissions = jwt.getClaim("permissions").asArray(String.class);
        List<SimpleGrantedAuthority> permissionsList = Stream.of(permissions)
                .map(permission -> new SimpleGrantedAuthority(permission))
                .collect(Collectors.toList());

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(jwt.getSubject(), null, permissionsList);
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);


        filterChain.doFilter(request, response);
    }
}
