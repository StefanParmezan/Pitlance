package com.example.JpaPractice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.JpaPractice.Models.ClientModelAndDTO.Client;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> getClientByName(String name);
    Optional<Client>getClientById(Long id);
}
