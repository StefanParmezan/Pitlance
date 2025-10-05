package com.example.JpaPractice.Services;

import com.example.JpaPractice.Models.ClientModelAndDTO.Client;
import com.example.JpaPractice.Models.ClientModelAndDTO.ClientNameEmailOrdersDto;
import com.example.JpaPractice.Models.OrderModelAndDTO.Order;
import com.example.JpaPractice.Models.OrderModelAndDTO.OrderUserIdStatusCreatedAtId;
import com.example.JpaPractice.Models.StatusAndDTO.Status;
import com.example.JpaPractice.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientService {
    //Variables
    private final ClientRepository clientRepository;

    private final OrderService orderService;

    private final PasswordEncoder passwordEncoder;

    //Constructor
    @Autowired
    public ClientService(ClientRepository clientRepository,
                         OrderService orderService, PasswordEncoder passwordEncoder){
        this.clientRepository = clientRepository;
        this.orderService = orderService;
        this.passwordEncoder = passwordEncoder;
    }

    //Methods

    public Client saveClient(Client client) {
        String hashedPassword = passwordEncoder.encode(client.getPassword());
        client.setPassword(hashedPassword);
        return clientRepository.save(client);
    }

    public Client getClientById(Long id){
        return clientRepository.getClientById(id).orElseThrow();
    }

    public ClientNameEmailOrdersDto getClientNameEmailOrdersDtoById(Long id){
        return ClientNameEmailOrdersDto.of(getClientById(id));
    }

    public Client getClientByName(String name) {
        return clientRepository.getClientByName(name).orElseThrow();
    }

        @Transactional
        public ClientNameEmailOrdersDto addOrder(Long id){
            Order order = new Order(LocalDateTime.now(), Status.NEW);
            Client client = getClientById(id);
            client.addOrder(client, order);
            orderService.save(order);
            return ClientNameEmailOrdersDto.of(client);
        }


}
