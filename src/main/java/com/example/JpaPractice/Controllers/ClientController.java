package com.example.JpaPractice.Controllers;

import com.example.JpaPractice.Models.ClientModelAndDTO.Client;
import com.example.JpaPractice.Models.ClientModelAndDTO.ClientNameEmailPasswordDto;
import com.example.JpaPractice.Models.ClientModelAndDTO.ClientNameEmailOrdersDto;
import com.example.JpaPractice.Models.OrderModelAndDTO.Order;
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
    public ResponseEntity<Client> save(@RequestBody ClientNameEmailPasswordDto client){
        return ResponseEntity.ok(clientService.saveClient(new Client(client.name(), client.email(), client.password())));
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @RequestMapping("/order")
    public ResponseEntity<ClientNameEmailOrdersDto> addOrder(@RequestParam Long id){
        return ResponseEntity.ok(clientService.addOrder(clientService.getClientById(id), new Order()));
    }
}
