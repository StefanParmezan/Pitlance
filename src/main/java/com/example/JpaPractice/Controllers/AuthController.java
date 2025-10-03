package com.example.JpaPractice.Controllers;

import com.example.JpaPractice.Models.Auth.AuthLoginRequest;
import com.example.JpaPractice.Models.Auth.AuthLoginResponse;
import com.example.JpaPractice.JWT.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthLoginResponse> login(@RequestBody AuthLoginRequest authLoginRequest) {
        AuthLoginResponse response = authService.authenticate(
                authLoginRequest.getUsername(),
                authLoginRequest.getPassword()
        );

        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body(response);
        }
    }
}