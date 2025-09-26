package com.example.JpaPractice.Controllers;

import com.example.JpaPractice.Models.ClientModelAndDTO.Client;
import com.example.JpaPractice.Models.ClientModelAndDTO.ClientToSaveDTO;
import com.example.JpaPractice.Models.OrderModelAndDTO.Order;
import com.example.JpaPractice.Models.OrderModelAndDTO.OrderToSaveDTO;
import com.example.JpaPractice.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @RequestMapping("/saveClient")
    public ResponseEntity<Client> save(@RequestBody ClientToSaveDTO client){
        return ResponseEntity.ok(clientService.saveClient(new Client(client.name(), client.email())));
    }
}
