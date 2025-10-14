package com.example.Pitlance.Models.OrderModelAndDTO;

public record ItemIdNamePrice(Long id, String itemName, Integer price) {
    public static ItemIdNamePrice of(Item item){
        return new ItemIdNamePrice(item.getId(), item.getItemName(), item.getPrice());
    }
}
