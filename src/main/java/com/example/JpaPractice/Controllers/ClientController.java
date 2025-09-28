package com.example.JpaPractice.Controllers;

import com.example.JpaPractice.Models.ClientModelAndDTO.Client;
import com.example.JpaPractice.Models.ClientModelAndDTO.ClientNameEmailDto;
import com.example.JpaPractice.Models.ClientModelAndDTO.ClientNameEmailOrdersDto;
import com.example.JpaPractice.Models.OrderModelAndDTO.Order;
import com.example.JpaPractice.Models.OrderModelAndDTO.OrderStatusCreatedAtId;
import com.example.JpaPractice.Services.ClientService;
import com.example.JpaPractice.Services.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;
    private final OrderService orderService;

    @Autowired
    public ClientController(ClientService clientService, OrderService orderService){
        this.clientService = clientService;
        this.orderService = orderService;
    }

    @RequestMapping
    public ResponseEntity<Client> save(@RequestBody ClientNameEmailDto client){
        return ResponseEntity.ok(clientService.saveClient(new Client(client.name(), client.email())));
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    //Recursion Client list with orders, next target: fix it
    @RequestMapping("/order")
    public ResponseEntity<ClientNameEmailOrdersDto> addOrder(@RequestBody ClientNameEmailDto clientNameEmailDto){
        Order order = new Order();
        Client client = clientService.addOrder(clientService.getClientByName(clientNameEmailDto.name()), order);
        List<OrderStatusCreatedAtId> list = client.getOrders().stream().map(o -> new OrderStatusCreatedAtId(order.getId(), o.getStatus(), o.getCreatedAt())).toList();
        return ResponseEntity.ok(new ClientNameEmailOrdersDto(client.getName(), client.getEmail(), list));
    }
}
