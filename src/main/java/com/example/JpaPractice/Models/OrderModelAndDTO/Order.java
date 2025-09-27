package com.example.JpaPractice.Models.OrderModelAndDTO;

import com.example.JpaPractice.Models.ClientModelAndDTO.Client;
import com.example.JpaPractice.Models.ItemModelAndDTO.Item;
import com.example.JpaPractice.Models.StatusOrderAndDTO.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    //Variables
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders")
    private Client client;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "order")
    List<Item> items = new ArrayList<>();

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Order() {
    }

    //Constructors


    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void add(Item item){
        this.items.add(item);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    //Other methods
}
