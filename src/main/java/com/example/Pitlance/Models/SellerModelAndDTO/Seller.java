package com.example.Pitlance.Models.SellerModelAndDTO;

import com.example.Pitlance.Models.OrderModelAndDTO.Item;
import jakarta.persistence.*;

import java.math.BigDecimal;
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
    private String companyName;

    @Column(name = "seller_name")
    private String sellerName;

    @Column(name = "seller_last_name")
    private String sellerLastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private int phoneNumber;

    @OneToMany(mappedBy = "seller")
    private final List<Item> items = new ArrayList<>();
    
    @Column(name = "taxPayerId")
    private String taxPayerId;

    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(name = "password")
    private String password;

    public Seller() {
    }

    //Constructors
    public Seller(String companyName, String sellerName, String sellerLastName, String email, Integer phoneNumber, String taxPayerId, BigDecimal balance, String password){
        this.companyName = companyName;
        this.sellerName = sellerName;
        this.sellerLastName = sellerLastName;
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

    public String getTaxPayerId() {
        return taxPayerId;
    }

    public void setTaxPayerId(String taxPayerId) {
        this.taxPayerId = taxPayerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerLastName() {
        return sellerLastName;
    }

    public void setSellerLastName(String sellerLastName) {
        this.sellerLastName = sellerLastName;
    }
}