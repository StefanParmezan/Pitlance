package com.example.Pitlance.Models.ClientModelAndDTO;

import com.example.Pitlance.Models.OrderModelAndDTO.ItemUserIdStatusCreatedAtId;

import java.util.List;

public record ClientNameEmailItemsDto(Long id, String name, String email, List<ItemUserIdStatusCreatedAtId> cart) {
    public static ClientNameEmailItemsDto of(Client client){
        List<ItemUserIdStatusCreatedAtId> itemUserIdStatusCreatedAtIdList = client.getCart().stream().map(ItemUserIdStatusCreatedAtId::of).toList();
        return new ClientNameEmailItemsDto(client.getId(), client.getName(), client.getEmail(), itemUserIdStatusCreatedAtIdList);
    }

    @Override
    public String toString() {
        return "ClientNameEmailOrdersDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cart=" + cart +
                '}';
    }
}
