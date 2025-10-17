package com.example.Pitlance.Models.SellerModelAndDTO;

public record SellerNameEmailBalancePhonePasswordTPI(String sellerName, String email, Integer phoneNumber, Integer taxPayerId, Integer balance, String password) {
    public static SellerNameEmailBalancePhonePasswordTPI of(Seller seller){
        return new SellerNameEmailBalancePhonePasswordTPI(seller.getSellerName(), seller.getEmail(), seller.getPhoneNumber(), seller.getTaxPayerId(), seller.getBalance(), seller.getPassword());
    }
}
