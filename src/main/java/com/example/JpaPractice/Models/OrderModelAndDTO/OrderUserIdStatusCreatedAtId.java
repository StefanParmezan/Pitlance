package com.example.JpaPractice.Models.OrderModelAndDTO;

import com.example.JpaPractice.Models.StatusOrderAndDTO.Status;

import java.time.LocalDateTime;

public record OrderUserIdStatusCreatedAtId(Long id, Long userId, Status status, LocalDateTime createdAt) {

}
