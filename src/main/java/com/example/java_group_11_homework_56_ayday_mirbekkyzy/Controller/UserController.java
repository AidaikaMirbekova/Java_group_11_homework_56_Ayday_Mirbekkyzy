package com.example.java_group_11_homework_56_ayday_mirbekkyzy.Controller;

import com.example.java_group_11_homework_56_ayday_mirbekkyzy.DTO.UserDTO;
import com.example.java_group_11_homework_56_ayday_mirbekkyzy.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO user) throws Exception {
        userService.register(user);
        return ResponseEntity.ok().build();
    }
}
