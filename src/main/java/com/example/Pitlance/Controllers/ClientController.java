package com.example.Pitlance.Controllers;

import com.example.Pitlance.Models.ClientModelAndDTO.ClientNameEmailPasswordDto;
import com.example.Pitlance.Models.ClientModelAndDTO.ClientNameEmailItemsDto;
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
    public ResponseEntity<ClientNameEmailItemsDto> save(@RequestBody ClientNameEmailPasswordDto client){
        return ResponseEntity.ok(clientService.save(client));
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientNameEmailItemsDto> getClientNameEmailOrdersDtoById(@PathVariable Long clientId){
        return ResponseEntity.ok(clientService.getClientNameEmailOrdersDtoById(clientId));
    }
}
