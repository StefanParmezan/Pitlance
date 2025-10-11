package com.example.Pitlance.Models.OrderModelAndDTO;

import com.example.Pitlance.Models.ClientModelAndDTO.Client;
import com.example.Pitlance.Models.StatusAndDTO.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="cart")
public class Item {
    //Variables
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private int price;

    @Column
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart")
    private Client client;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Status status;


    //Constructors

    public Item() {

    }

    public Item(String name, int price){
        this.name = name;
        this.price = price;
    }



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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Other methods
}
