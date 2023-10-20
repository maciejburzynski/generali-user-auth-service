package com.generali.userauthservice.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
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
    UserLoginResponse login(@RequestBody @Valid UserDto userDto) {
        log.info("{} trying to log in", userDto.getUsername());
        return userService.validateUser(userDto);
    }

    @Operation(summary = "Register user into user-auth-service", description = "Register user")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Valid request executed and 201 returned")
    })
    @PostMapping("api/register")
    ResponseEntity register(@RequestBody @Valid UserDto userDto) {
        log.info("{} trying to register in", userDto.getUsername());
        userService.registerUser(userDto);
        return ResponseEntity.status(201).build();
    }

//    TODO: add field of activation uuid into user entity
    @Operation(summary = "Activate user in user-auth-service", description = "Activate user")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Valid request executed and 200 returned")
    })
    @GetMapping("api/activate/{uuid}")
    ResponseEntity activate(@PathVariable String uuid) {
        log.info("UUID: {} trying to activate in", uuid);
        User userToActivate = userService.activateUser(uuid);
        log.info("user found: {}", userToActivate.toString());
        return ResponseEntity.status(200).build();
    }

    @Operation(summary = "Get all registered users with their authorities", description = "All Users")
    @SecurityRequirement(name = "Bearer Authentication")
    @ApiResponses({
            @ApiResponse(responseCode = "403", description = "Not valid credentials"),
            @ApiResponse(responseCode = "200", description = "Valid credentials and token returned")
    })
    @GetMapping("api/users")
    Page<User> getAllUsers(@PageableDefault(size = 2) Pageable pageable) {
        log.info("Getting all users");
        return userService.findAll(pageable);
    }
}
