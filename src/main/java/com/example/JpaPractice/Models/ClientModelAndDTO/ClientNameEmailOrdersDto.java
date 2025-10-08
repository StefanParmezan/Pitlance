package com.example.JpaPractice.Models.ClientModelAndDTO;

import com.example.JpaPractice.Models.OrderModelAndDTO.OrderUserIdStatusCreatedAtId;

import java.util.List;

public record ClientNameEmailOrdersDto(Long id, String name, String email, List<OrderUserIdStatusCreatedAtId> orders) {
    public static ClientNameEmailOrdersDto of(Client client){
        List<OrderUserIdStatusCreatedAtId> orderUserIdStatusCreatedAtIdList = client.getOrders().stream().map(OrderUserIdStatusCreatedAtId::of).toList();
        return new ClientNameEmailOrdersDto(client.getId(), client.getName(), client.getEmail(), orderUserIdStatusCreatedAtIdList);
    }

    @Override
    public String toString() {
        return "ClientNameEmailOrdersDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", orders=" + orders +
                '}';
    }
}
