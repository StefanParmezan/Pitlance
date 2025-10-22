package com.example.Pitlance.Services;

import com.example.Pitlance.Models.SellerModelAndDTO.Seller;
import com.example.Pitlance.Models.SellerModelAndDTO.SellerNameEmailBalancePhonePasswordTPI;
import com.example.Pitlance.Repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    SellerRepository sellerRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SellerService(SellerRepository sellerRepository,
                         PasswordEncoder passwordEncoder){
        this.sellerRepository = sellerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Seller save(SellerNameEmailBalancePhonePasswordTPI sellerNameEmailBalancePhonePasswordTPI){
        Seller seller = new Seller(
                sellerNameEmailBalancePhonePasswordTPI.companyName(),
                sellerNameEmailBalancePhonePasswordTPI.sellerName(),
                sellerNameEmailBalancePhonePasswordTPI.sellerLastName(),
                sellerNameEmailBalancePhonePasswordTPI.email(),
                sellerNameEmailBalancePhonePasswordTPI.phoneNumber(),
                sellerNameEmailBalancePhonePasswordTPI.taxPayerId(),
                sellerNameEmailBalancePhonePasswordTPI.balance(),
                sellerNameEmailBalancePhonePasswordTPI.password()
                );
        seller.setPassword(passwordEncoder.encode(seller.getPassword()));
        return sellerRepository.save(seller);
    }
}
