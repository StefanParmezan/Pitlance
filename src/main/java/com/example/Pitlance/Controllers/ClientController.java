package com.example.Pitlance.Controllers;

import com.example.Pitlance.Models.ClientModelAndDTO.ClientNameEmailPassword;
import com.example.Pitlance.Models.ClientModelAndDTO.ClientNameEmailItems;
import com.example.Pitlance.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientNameEmailItems> save(@RequestBody ClientNameEmailPassword client){
        return ResponseEntity.ok(clientService.save(client));
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientNameEmailItems> getClientNameEmailOrdersDtoById(@PathVariable Long clientId){
        return ResponseEntity.ok(clientService.getClientNameEmailOrdersDtoById(clientId));
    }
}
