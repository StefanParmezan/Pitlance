package com.example.Pitlance.Models.OrderModelAndDTO;

import com.example.Pitlance.Models.ClientModelAndDTO.Client;
import com.example.Pitlance.Models.SellerModelAndDTO.Seller;
import com.example.Pitlance.Models.StatusAndDTO.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="items")
public class Item {
    //Variables
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "price")
    private int price;

    @Column(name = "quantity")
    private int quantity;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart")
    private Client client;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name="seller")
    private Seller seller;


    //Constructors

    public Item() {

    }

    public Item(String itemName, int price){
        this.itemName = itemName;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    //Other methods
}
