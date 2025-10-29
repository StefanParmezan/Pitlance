package com.example.Pitlance.Models.SellerModelAndDTO;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * DTO for {@link Seller}
 */
public record SellerCompanyNameEmailPhoneTPIBalance (Long id, String companyName, String sellerName, String sellerLastName,  BigDecimal balance, String taxPayerId, long phoneNumber, String email){
        public static SellerCompanyNameEmailPhoneTPIBalance of(Seller seller){
            return new SellerCompanyNameEmailPhoneTPIBalance(
                    seller.getId(),
                    seller.getCompanyName(),
                    seller.getSellerName(),
                    seller.getSellerLastName(),
                    seller.getBalance(),
                    seller.getTaxPayerId(),
                    seller.getPhoneNumber(),
                    seller.getEmail()
            );
        }
}