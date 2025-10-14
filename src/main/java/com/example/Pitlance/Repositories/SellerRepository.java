package com.example.Pitlance.Repositories;

import com.example.Pitlance.Models.SellerModelAndDTO.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    public Optional<Seller> getSellerBySellerName(String sellerName);

}
