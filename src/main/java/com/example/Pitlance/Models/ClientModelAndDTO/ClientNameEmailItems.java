package com.example.Pitlance.Models.ClientModelAndDTO;

import com.example.Pitlance.Models.OrderModelAndDTO.ItemUserIdStatusCreatedAtId;

import java.util.List;

public record ClientNameEmailItems(Long id, String clientName, String email, List<ItemUserIdStatusCreatedAtId> cart) {
    public static ClientNameEmailItems of(Client client){
        List<ItemUserIdStatusCreatedAtId> itemUserIdStatusCreatedAtIdList = client.getCart().stream().map(ItemUserIdStatusCreatedAtId::of).toList();
        return new ClientNameEmailItems(client.getId(), client.getClientName(), client.getEmail(), itemUserIdStatusCreatedAtIdList);
    }

    @Override
    public String toString() {
        return "ClientNameEmailOrdersDto{" +
                "id=" + id +
                ", itemName='" + clientName + '\'' +
                ", email='" + email + '\'' +
                ", cart=" + cart +
                '}';
    }
}
