package com.generali.userauthservice.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "User API", description = "Login, register and getting users")
public class UserRestController {

    private final UserService userService;

    @Operation(summary = "Authenticate user to get valid JWT", description = "Login user")
    @ApiResponses({
            @ApiResponse(responseCode = "403", description = "Not Valid credentials"),
            @ApiResponse(responseCode = "200", description = "Valid credentials and token returned")
    })
    @PostMapping("api/login")
    UserLoginResponse login(@RequestBody @Valid UserLoginRequest userLoginRequest) {
        return userService.validateUser(userLoginRequest);
    }

    @Operation(summary = "Get all registered users with their authorities", description = "All Users")
    @SecurityRequirement(name = "Bearer Authentication")
    @ApiResponses({
            @ApiResponse(responseCode = "403", description = "Not valid credentials"),
            @ApiResponse(responseCode = "200", description = "Valid credentials and token returned")
    })

    @GetMapping("api/users")
    Page<User> getAllUsers(@PageableDefault(size = 2) Pageable pageable) {
        return userService.findAll(pageable);
    }
}
