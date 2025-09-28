package com.example.JpaPractice.Models.OrderModelAndDTO;

import com.example.JpaPractice.Models.StatusOrderAndDTO.Status;

import java.time.LocalDateTime;

public record OrderStatusCreatedAtId(Long id, Status status, LocalDateTime createdAt) {

}
