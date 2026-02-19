package com.careerit.controller;

import org.springframework.web.bind.annotation.*;

import com.careerit.config.JwtUtil;
import com.careerit.dto.AuthResponse;
import com.careerit.dto.ForgotPasswordRequest;
import com.careerit.dto.LoginRequest;
import com.careerit.entity.User;
import com.careerit.service.AuthService;

@RestController
@CrossOrigin
public class AuthController {

    private final AuthService userService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
    	return userService.login(request);
    }
    
    @PostMapping("/forget-password")
    public String forgotPassword(@RequestBody ForgotPasswordRequest request) {
        return userService.forgotPassword(request.getEmail());
    }

    
    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String token,
                                @RequestParam String newPassword) {
        return userService.resetPassword(token, newPassword);
    }

}
