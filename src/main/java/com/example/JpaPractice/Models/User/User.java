package com.example.JpaPractice.Models.User;

import com.example.JpaPractice.Models.Car.Car;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_")
public class User {
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="password")
    private String password;

    @Column(name="name", unique = true, nullable = false)
    private String username;

    @Column(name="cars")
    @OneToMany(mappedBy = "owner")
    List<Car> cars = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addCar(Car car){
        this.cars.add(car);
    }
}