package com.example.Pitlance.Models.SellerModelAndDTO;

public record SellerNameEmailBalancePhonePasswordTPI(String companyName, String sellerName, String sellerLastName, String email, Integer phoneNumber, String taxPayerId, Integer balance, String password) {
    public static SellerNameEmailBalancePhonePasswordTPI of(Seller seller){
        return new SellerNameEmailBalancePhonePasswordTPI(seller.getCompanyName(), seller.getSellerName(), seller.getSellerLastName(), seller.getEmail(), seller.getPhoneNumber(), seller.getTaxPayerId(), seller.getBalance(), seller.getPassword());
    }
}
