package com.example.JpaPractice.Services;

import com.example.JpaPractice.Models.ClientModelAndDTO.Client;
import com.example.JpaPractice.Models.OrderModelAndDTO.Order;
import com.example.JpaPractice.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Client addOrder(Client client, Order order){
        client.addOrder(order);
        return client;
    }


}
