package com.example.JpaPractice.Services;

import com.example.JpaPractice.Models.ClientModelAndDTO.Client;
import com.example.JpaPractice.Models.OrderModelAndDTO.Order;
import com.example.JpaPractice.Models.StatusOrderAndDTO.Status;
import com.example.JpaPractice.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClientService {
    //Variables
    private final ClientRepository clientRepository;

    //Constructor
    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    //Methods

    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

    public Client getClientById(Long id){
        return clientRepository.getClientById(id).orElseThrow();
    }

    public Client getClientByName(String name) {
        return clientRepository.getClientByName(name).orElseThrow();
    }

    public Client addOrder(Client client, Order order){
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus(Status.NEW);
        return client.addOrder(client, order);
    }


}
