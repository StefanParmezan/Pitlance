package com.example.Pitlance.Models.SellerModelAndDTO;

public record SellerEmailPhonePasswordTPI(String email, Integer phone, String password, String taxPayerId) {
    public static SellerEmailPhonePasswordTPI of(Seller seller){
        return new SellerEmailPhonePasswordTPI(seller.getEmail(), seller.getPhoneNumber(), seller.getPassword(), seller.getTaxPayerId());
    }
}
