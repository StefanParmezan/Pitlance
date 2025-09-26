package com.example.JpaPractice.Repositories;

import com.example.JpaPractice.Models.OrderModelAndDTO.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
