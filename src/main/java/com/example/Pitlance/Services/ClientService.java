package com.example.Pitlance.Services;

import com.example.Pitlance.Models.ClientModelAndDTO.Client;
import com.example.Pitlance.Models.ClientModelAndDTO.ClientNameEmailItems;
import com.example.Pitlance.Models.ClientModelAndDTO.ClientNameEmailPassword;
import com.example.Pitlance.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    //Variables
    private final ClientRepository clientRepository;

    private final PasswordEncoder passwordEncoder;

    //Constructor
    @Autowired
    public ClientService(ClientRepository clientRepository, PasswordEncoder passwordEncoder){
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //Methods

    public ClientNameEmailItems save(ClientNameEmailPassword clientNameEmailPassword) {
        Client client = new Client(clientNameEmailPassword.name(), clientNameEmailPassword.email(), clientNameEmailPassword.password());
        String hashedPassword = passwordEncoder.encode(client.getPassword());
        client.setPassword(hashedPassword);
        clientRepository.save(client);
        return ClientNameEmailItems.of(client);
    }

    public Client getClientById(Long id){
        return clientRepository.getClientById(id).orElseThrow();
    }

    public ClientNameEmailItems getClientNameEmailOrdersDtoById(Long id){
        ClientNameEmailItems clientNameEmailItems = ClientNameEmailItems.of(getClientById(id));
        System.out.println(clientNameEmailItems.toString());
        return clientNameEmailItems;
    }

    public Client getClientByName(String name) {
        return clientRepository.getClientByClientName(name).orElseThrow();
    }



}
