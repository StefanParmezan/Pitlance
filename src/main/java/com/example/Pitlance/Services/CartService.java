package com.example.Pitlance.Services;

import com.example.Pitlance.Models.ClientModelAndDTO.Client;
import com.example.Pitlance.Models.ClientModelAndDTO.ClientNameEmailItems;
import com.example.Pitlance.Models.OrderModelAndDTO.Item;
import com.example.Pitlance.Models.OrderModelAndDTO.ItemClientIdId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartService {

    private final ClientService clientService;

    private final ItemService itemService;

    @Autowired
    public CartService(ClientService clientService, ItemService itemService) {
        this.clientService = clientService;
        this.itemService = itemService;
    }

    @Transactional
    public ClientNameEmailItems addItemToCart(ItemClientIdId itemClientIdId){
        Client client = clientService.getClientById(itemClientIdId.clientId());
        Item item = itemService.getItemById(itemClientIdId.itemId());
        client.addItemToCart(item);
        return ClientNameEmailItems.of(client);
    }
}
