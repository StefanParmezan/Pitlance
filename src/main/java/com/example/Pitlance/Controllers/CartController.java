package com.example.Pitlance.Controllers;

import com.example.Pitlance.Models.ClientModelAndDTO.ClientNameEmailItemsDto;
import com.example.Pitlance.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping
    public ResponseEntity<ClientNameEmailItemsDto> addItemToCart(@RequestBody Long clientId, Long itemId){
        return ResponseEntity.ok(cartService.addItemToCart(clientId, itemId));
    }
}
