package com.example.Pitlance.Models.OrderModelAndDTO;

import com.example.Pitlance.Models.StatusAndDTO.Status;

import java.time.LocalDateTime;

public record ItemUserIdStatusCreatedAtId(Long id, Long userId, Status status, LocalDateTime createdAt) {
    public static ItemUserIdStatusCreatedAtId of(Item item){
        return new ItemUserIdStatusCreatedAtId(item.getId(), item.getClient().getId(), item.getStatus(), item.getCreatedAt());
    }
}
