package com.example.Pitlance.Services;

import com.example.Pitlance.Models.ClientModelAndDTO.Client;
import com.example.Pitlance.Models.ClientModelAndDTO.ClientNameEmailItemsDto;
import com.example.Pitlance.Models.OrderModelAndDTO.Item;
import com.example.Pitlance.Models.OrderModelAndDTO.ItemClientIdId;
import com.example.Pitlance.Repositories.ItemRepository;
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
    public ClientNameEmailItemsDto addItemToCart(ItemClientIdId itemClientIdId){
        Client client = clientService.getClientById(itemClientIdId.clientId());
        Item item = itemService.getItemById(itemClientIdId.itemId());
        client.addItemToCart(item);
        return ClientNameEmailItemsDto.of(client);
    }
}
