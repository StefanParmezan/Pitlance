package com.example.JpaPractice.JWT;

import com.example.JpaPractice.Models.Auth.AuthLoginResponse;
import com.example.JpaPractice.Models.ClientModelAndDTO.Client;
import com.example.JpaPractice.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public AuthLoginResponse authenticate(String username, String password) {
        Client authClient = clientRepository.getClientByName(username)
                .orElse(null);

        if (authClient == null) {
            return new AuthLoginResponse(null, "User not found", false);
        }

        System.out.println(password);
        System.out.println(authClient.getPassword());
        if (!passwordEncoder.matches(password, authClient.getPassword())) {
            return new AuthLoginResponse(null, "Invalid password", false);
        }

        String token = jwtService.generateToken(username, "USER");

        return new AuthLoginResponse(token, "Login successful", true);
    }


}