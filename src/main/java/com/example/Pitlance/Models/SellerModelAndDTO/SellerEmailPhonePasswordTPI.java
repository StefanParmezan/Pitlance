package com.example.Pitlance.Models.SellerModelAndDTO;

public record SellerEmailPhonePasswordTPI(String email, Long phone, String password, String taxPayerId) {
    public static SellerEmailPhonePasswordTPI of(Seller seller){
        return new SellerEmailPhonePasswordTPI(seller.getEmail(), seller.getPhoneNumber(), seller.getPassword(), seller.getTaxPayerId());
    }

    @Override
    public String toString() {
        return "SellerEmailPhonePasswordTPI{" +
                "email='" + email + '\'' +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                ", taxPayerId='" + taxPayerId + '\'' +
                '}';
    }
}
