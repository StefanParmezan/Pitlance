package com.example.Pitlance.Repositories;

import com.example.Pitlance.Models.ClientModelAndDTO.Client;
import com.example.Pitlance.Models.OrderModelAndDTO.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> getItemById(Long id);
    Optional<Item> getItemByClient(Client client);
}
