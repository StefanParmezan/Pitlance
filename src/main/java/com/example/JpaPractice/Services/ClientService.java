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
        // Хешируем пароль перед сохранением
        if (client.getPassword() != null && !client.getPassword().startsWith("$2a$")) {
            String encodedPassword = passwordEncoder.encode(client.getPassword());
            client.setPassword(encodedPassword);
        }
        return clientRepository.save(client);
    }

    public Client getClientById(Long id){
        return clientRepository.getClientById(id).orElseThrow();
    }

    public Client getClientByName(String name) {
        return clientRepository.getClientByName(name).orElseThrow();
    }

    @Transactional
    public ClientNameEmailOrdersDto addOrder(Client client, Order order){
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus(Status.NEW);
        client.addOrder(client, order);
        orderService.save(order);
        System.out.println(client.getOrders());
        List<Order> orders = client.getOrders();
        List<OrderUserIdStatusCreatedAtId> orderUserIdStatusCreatedAtIdList = orders.stream().map(o -> new OrderUserIdStatusCreatedAtId(o.getId(), o.getClient().getId(), o.getStatus(), o.getCreatedAt())).toList();
        System.out.println(orderUserIdStatusCreatedAtIdList);
        return new ClientNameEmailOrdersDto(client.getId(), client.getName(), client.getEmail(), orderUserIdStatusCreatedAtIdList);
    }


}
