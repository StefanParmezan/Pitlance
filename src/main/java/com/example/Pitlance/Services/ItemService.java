package com.example.Pitlance.Services;

import com.example.Pitlance.Models.OrderModelAndDTO.Item;
import com.example.Pitlance.Models.OrderModelAndDTO.ItemIdNamePrice;
import com.example.Pitlance.Models.OrderModelAndDTO.ItemTPINamePrice;
import com.example.Pitlance.Repositories.ItemRepository;
import com.example.Pitlance.Repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    private final SellerService sellerService;

    @Autowired
    public ItemService(ItemRepository itemRepository,
                       SellerService sellerService) {
        this.itemRepository = itemRepository;
        this.sellerService = sellerService;
    }

    public Item getItemById(Long id){
        return itemRepository.getItemById(id).orElseThrow();
    }

    @Transactional
    public ItemIdNamePrice save(ItemTPINamePrice itemTPINamePrice) {
        System.out.println(itemTPINamePrice);
        Item item = itemRepository.save(new Item(itemTPINamePrice.itemName(), itemTPINamePrice.price(), sellerService.getSellerByTPI(itemTPINamePrice.taxPayerId())));
        return ItemIdNamePrice.of(item);
    }

}
