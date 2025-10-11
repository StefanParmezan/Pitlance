package com.example.Pitlance.Services;

import com.example.Pitlance.Models.ClientModelAndDTO.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private ClientService clientService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean authenticate(String username, String password) {
        Client client = clientService.getClientByName(username);
        return passwordEncoder.matches(password, client.getPassword());
    }
}