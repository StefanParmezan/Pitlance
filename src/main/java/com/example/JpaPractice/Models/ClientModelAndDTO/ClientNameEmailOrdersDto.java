package com.example.JpaPractice.Models.ClientModelAndDTO;

import com.example.JpaPractice.Models.OrderModelAndDTO.OrderStatusCreatedAtId;

import java.util.List;

public record ClientNameEmailOrdersDto(String name, String email, List<OrderStatusCreatedAtId> orders) {
}
