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
    public ResponseEntity<ClientNameEmailOrdersDto> save(@RequestBody ClientNameEmailPasswordDto client){
        return ResponseEntity.ok(clientService.saveClient(client));
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientNameEmailOrdersDto> getClientNameEmailOrdersDtoById(@PathVariable Long clientId){
        return ResponseEntity.ok(clientService.getClientNameEmailOrdersDtoById(clientId));
    }

    @RequestMapping("/orders/{clientId}")
    public ResponseEntity<ClientNameEmailOrdersDto> addOrder(@PathVariable Long clientId){
        return ResponseEntity.ok(clientService.addOrder(clientId));
    }
}
