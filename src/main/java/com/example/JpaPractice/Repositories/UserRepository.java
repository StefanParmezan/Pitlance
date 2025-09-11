package com.example.JpaPractice.Repositories;

import com.example.JpaPractice.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByName(String name);
}
