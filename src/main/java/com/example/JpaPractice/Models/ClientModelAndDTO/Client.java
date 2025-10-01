package com.example.JpaPractice.Models.ClientModelAndDTO;

import com.example.JpaPractice.Models.OrderModelAndDTO.Order;
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
    List<Order> orders = new ArrayList<>();

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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void add(Order order){
        this.orders.add(order);
    }

    //Other methods

    public void addOrder(Client client, Order order){
        client.orders.add(order);
        order.setClient(client);
    }
}
