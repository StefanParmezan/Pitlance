package com.example.Pitlance.Services;

import com.example.Pitlance.Models.ClientModelAndDTO.Client;
import com.example.Pitlance.Models.ClientModelAndDTO.ClientNameEmailItemsDto;
import com.example.Pitlance.Models.ClientModelAndDTO.ClientNameEmailPasswordDto;
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

    public ClientNameEmailItemsDto save(ClientNameEmailPasswordDto clientNameEmailPasswordDto) {
        Client client = new Client(clientNameEmailPasswordDto.name(), clientNameEmailPasswordDto.email(), clientNameEmailPasswordDto.password());
        String hashedPassword = passwordEncoder.encode(client.getPassword());
        client.setPassword(hashedPassword);
        clientRepository.save(client);
        return ClientNameEmailItemsDto.of(client);
    }

    public Client getClientById(Long id){
        return clientRepository.getClientById(id).orElseThrow();
    }

    public ClientNameEmailItemsDto getClientNameEmailOrdersDtoById(Long id){
        ClientNameEmailItemsDto clientNameEmailItemsDto = ClientNameEmailItemsDto.of(getClientById(id));
        System.out.println(clientNameEmailItemsDto.toString());
        return clientNameEmailItemsDto;
    }

    public Client getClientByName(String name) {
        return clientRepository.getClientByName(name).orElseThrow();
    }



}
