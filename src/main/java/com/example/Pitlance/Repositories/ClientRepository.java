package com.example.Pitlance.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Pitlance.Models.ClientModelAndDTO.Client;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> getClientByClientName(String name);
    Optional<Client>getClientById(Long id);
}
