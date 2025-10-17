package com.example.Pitlance.Models.SellerModelAndDTO;

import com.example.Pitlance.Models.OrderModelAndDTO.Item;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sellers")
public class Seller {
    //Variables
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "company_name")
    private String sellerName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @OneToMany(mappedBy = "seller")
    private final List<Item> items = new ArrayList<>();
    
    @Column(name = "taxPayerId")
    private Integer taxPayerId;

    @Column(name = "balance")
    private Integer balance = 0;

    @Column(name = "password")
    private String password;

    public Seller() {
    }

    //Constructors
    public Seller(String sellerName, String email, Integer phoneNumber, Integer taxPayerId, Integer balance, String password){
        this.sellerName = sellerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.taxPayerId = taxPayerId;
        this.balance = balance;
        this.password = password;
    }

    //Getters and Setters
    public List<Item> getItems() {
        return items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTaxPayerId() {
        return taxPayerId;
    }

    public void setTaxPayerId(Integer taxPayerId) {
        this.taxPayerId = taxPayerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}