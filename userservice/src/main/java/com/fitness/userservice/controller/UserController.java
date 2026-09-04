package com.fitness.userservice.controller;

import com.fitness.userservice.model.dto.RegisterRequest;
import com.fitness.userservice.model.dto.UserResponse;
import com.fitness.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserProfile(@PathVariable("userId") String userId) {
        log.info("Get user profile for {}", userId);
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }

    @GetMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest request) {
        log.info("Register request {}", request);
        return ResponseEntity.ok(userService.register(request));
    }

}
