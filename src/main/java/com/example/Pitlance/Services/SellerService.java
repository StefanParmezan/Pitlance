package com.example.Pitlance.Services;

import com.example.Pitlance.ApiConnecting.SellerApiConnector;
import com.example.Pitlance.Models.SellerModelAndDTO.Seller;
import com.example.Pitlance.Models.SellerModelAndDTO.SellerEmailPhonePasswordTPI;
import com.example.Pitlance.Models.SellerModelAndDTO.SellerNameEmailBalancePhonePasswordTPI;
import com.example.Pitlance.Repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    private final SellerRepository sellerRepository;
    private final SellerApiConnector sellerApiConnector;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SellerService(SellerRepository sellerRepository,
                         PasswordEncoder passwordEncoder, SellerApiConnector sellerApiConnector){
        this.sellerRepository = sellerRepository;
        this.passwordEncoder = passwordEncoder;
        this.sellerApiConnector = sellerApiConnector;
    }

    public Seller save(SellerEmailPhonePasswordTPI sellerEmailPhonePasswordTPI){
        SellerNameEmailBalancePhonePasswordTPI sellerNameEmailBalancePhonePasswordTPI = sellerApiConnector.validateSellerByTPI(sellerEmailPhonePasswordTPI);
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
