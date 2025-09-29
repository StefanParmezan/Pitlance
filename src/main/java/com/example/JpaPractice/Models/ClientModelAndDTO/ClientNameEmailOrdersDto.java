package com.example.JpaPractice.Models.ClientModelAndDTO;

import com.example.JpaPractice.Models.OrderModelAndDTO.OrderUserIdStatusCreatedAtId;

import java.util.List;

public record ClientNameEmailOrdersDto(Long id, String name, String email, List<OrderUserIdStatusCreatedAtId> orders) {
}
