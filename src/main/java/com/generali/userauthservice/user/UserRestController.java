package com.generali.userauthservice.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping("api/login")
    UserLoginResponse login(@RequestBody UserLoginRequest userLoginRequest){
        return userService.validateUser(userLoginRequest);
    }

    @GetMapping("api/users")
    List<User> getAllUsers(){
        return userService.findAll();
    }
}
