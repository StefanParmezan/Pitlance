package com.example.Pitlance.Models.ClientModelAndDTO;

import com.example.Pitlance.Models.OrderModelAndDTO.Item;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="clients")
public class Client {
    //Variables
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name= "client_name")
    private String clientName;

    @Column(name = "password")
    private String password;

    @Column(name="email", unique = true)
    private String email;

    @OneToMany(mappedBy = "client")
    private final List<Item> cart = new ArrayList<>();

    @Column(name="balance")
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(name="phone_number")
    private int phoneNumber;

    //Constructors
    public Client(){}

    public Client(String clientName, String email, String password){
        this.clientName = clientName;
        this.email = email;
        this.password = password;
    }


    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Item> getCart() {
        return cart;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //Other methods


    public void add(Item item){
        this.cart.add(item);
    }

    public void addItemToCart(Item item){
        this.cart.add(item);
        item.setClient(this);
    }
}
