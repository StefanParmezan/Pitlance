package com.example.Pitlance.Models.SalesMan;

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
    private String companyName;

    @OneToMany(mappedBy = "seller")
    private final List<Item> items = new ArrayList<>();
    
    @Column(name = "taxPayerId")
    private Integer taxPayerId;

    //Constructors


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
}