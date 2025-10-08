package com.example.JpaPractice.Controllers;
import com.example.JpaPractice.JWT.JwtService;
import com.example.JpaPractice.Models.Auth.AuthResponse;
import com.example.JpaPractice.Models.Auth.LoginRequest;
import com.example.JpaPractice.Services.AuthService;
import com.example.JpaPractice.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ClientService clientService;

    //g
    @PostMapping("/auth")
    public ResponseEntity<?> authenticate(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.username();
        String password = loginRequest.password();

        if (!authService.authenticate(username, password)) {
            return ResponseEntity.status(401).body("Неверный логин или пароль");
        }

        String token = jwtService.generateToken(username);
        AuthResponse response = new AuthResponse(clientService.getClientByName(username).getId(),token, username);
        return ResponseEntity.ok(response);
    }
}