package com.example.Pitlance.Models.SellerModelAndDTO;

import java.math.BigDecimal;

public record SellerNameEmailBalancePhonePasswordTPI(String companyName, String sellerName, String sellerLastName, String email, long phoneNumber, String taxPayerId, BigDecimal balance, String password) {
    public static SellerNameEmailBalancePhonePasswordTPI of(Seller seller){
        return new SellerNameEmailBalancePhonePasswordTPI(seller.getCompanyName(), seller.getSellerName(), seller.getSellerLastName(), seller.getEmail(), seller.getPhoneNumber(), seller.getTaxPayerId(), seller.getBalance(), seller.getPassword());
    }

    @Override
    public String toString() {
        return "SellerNameEmailBalancePhonePasswordTPI{" +
                "\ncompanyName=" + companyName + '\n' +
                ",sellerName=" + sellerName + '\n' +
                ",sellerLastName=" + sellerLastName + '\n' +
                ",email=" + email + '\n' +
                ",phoneNumber=" + phoneNumber + "\n" +
                ",taxPayerId=" + taxPayerId + '\n' +
                ",balance=" + balance + '\n' +
                ",password=" + password + '\n' +
                '}';
    }
}
