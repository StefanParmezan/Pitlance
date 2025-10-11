package com.example.Pitlance.Models.ClientModelAndDTO;

import com.example.Pitlance.Models.OrderModelAndDTO.Item;
import jakarta.persistence.*;

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

    @Column(name="name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name="email", unique = true)
    private String email;

    @OneToMany(mappedBy = "client")
    List<Item> cart = new ArrayList<>();

    @Column(name="balance")
    private Integer balance;

    //Constructors
    public Client(){}

    public Client(String name, String email, String password){
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
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
