package com.example.Pitlance.Controllers;

import com.example.Pitlance.Models.ClientModelAndDTO.ClientNameEmailItems;
import com.example.Pitlance.Models.OrderModelAndDTO.ItemClientIdId;
import com.example.Pitlance.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<ClientNameEmailItems> addItemToCart(@RequestBody ItemClientIdId itemClientIdId){
        return ResponseEntity.ok(cartService.addItemToCart(itemClientIdId));
    }
}
