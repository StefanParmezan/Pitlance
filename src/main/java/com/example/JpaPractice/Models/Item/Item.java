package com.example.JpaPractice.Models.Item;

import com.example.JpaPractice.Models.Order.Order;
import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    //Variables
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name = "order")
    @ManyToOne
    private Order order;

    //Constructor

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
