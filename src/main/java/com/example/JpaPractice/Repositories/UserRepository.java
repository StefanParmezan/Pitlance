package com.example.JpaPractice.Repositories;

import com.example.JpaPractice.Models.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> getUserById(Long id);
    public Optional<User> getUserByUsername(String username);
}
