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

    @Column(name="email", unique = true)
    private String email;

    @OneToMany(mappedBy = "client")
    List<Order> orders = new ArrayList<>();

    //Constructors
    public Client(){}

    public Client(String name, String email){
        this.name = name;
        this.email = email;
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
        System.out.println(client.orders + "pppp");
        order.setClient(client);
    }
}
