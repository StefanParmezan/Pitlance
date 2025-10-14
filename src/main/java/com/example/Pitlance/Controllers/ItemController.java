package com.example.Pitlance.Controllers;

import com.example.Pitlance.Models.OrderModelAndDTO.ItemIdNamePrice;
import com.example.Pitlance.Models.OrderModelAndDTO.ItemNamePrice;
import com.example.Pitlance.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemIdNamePrice> save(@RequestBody ItemNamePrice itemNamePrice){
        System.out.println(itemNamePrice.itemName() + " " + itemNamePrice.price());
        return ResponseEntity.ok(itemService.save(itemNamePrice));
    }
}
