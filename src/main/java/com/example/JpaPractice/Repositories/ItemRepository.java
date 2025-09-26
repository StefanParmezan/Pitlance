package com.example.JpaPractice.Repositories;

import com.example.JpaPractice.Models.ItemModelAndDTO.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
