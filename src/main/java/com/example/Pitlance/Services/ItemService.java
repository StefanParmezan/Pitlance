package com.example.Pitlance.Services;

import com.example.Pitlance.Models.OrderModelAndDTO.Item;
import com.example.Pitlance.Models.OrderModelAndDTO.ItemIdNamePrice;
import com.example.Pitlance.Models.OrderModelAndDTO.ItemNamePrice;
import com.example.Pitlance.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item getItemById(Long id){
        return itemRepository.getItemById(id).orElseThrow();
    }

    @Transactional
    public ItemIdNamePrice save(ItemNamePrice itemNamePrice) {
        Item item = new Item(itemNamePrice.itemName(), itemNamePrice.price());
        System.out.println(item.getItemName() + " " + item.getPrice());
        return ItemIdNamePrice.of(itemRepository.save(item));
    }
}
