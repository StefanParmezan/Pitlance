package com.example.JpaPractice.Controllers;

import com.example.JpaPractice.Models.ClientModelAndDTO.Client;
import com.example.JpaPractice.Models.ClientModelAndDTO.ClientNameAndEmailDto;
import com.example.JpaPractice.Models.OrderModelAndDTO.Order;
import com.example.JpaPractice.Models.OrderModelAndDTO.OrderClientDto;
import com.example.JpaPractice.Services.ClientService;
import com.example.JpaPractice.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Client> save(@RequestBody ClientNameAndEmailDto client){
        return ResponseEntity.ok(clientService.saveClient(new Client(client.name(), client.email())));
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    //Recursion Client list with orders, next target: fix it
    @RequestMapping("/order")
    public ResponseEntity<Client> addOrder(@RequestBody ClientNameAndEmailDto clientNameAndEmailDto){
        return ResponseEntity.ok(clientService.getClientByName(clientNameAndEmailDto.name()).addOrder(orderService.save(new Order())));
    }
}
