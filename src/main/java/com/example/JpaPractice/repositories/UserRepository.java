package com.example.JpaPractice.repositories;

import com.example.JpaPractice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User getByName(String name);
}
