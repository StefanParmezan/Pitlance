package com.example.Pitlance.Services;

import com.example.Pitlance.ApiConnecting.SellerApiConnector;
import com.example.Pitlance.Models.SellerModelAndDTO.Seller;
import com.example.Pitlance.Models.SellerModelAndDTO.SellerCompanyNameEmailPhoneTPIBalance;
import com.example.Pitlance.Models.SellerModelAndDTO.SellerEmailPhonePasswordTPI;
import com.example.Pitlance.Models.SellerModelAndDTO.SellerNameEmailBalancePhonePasswordTPI;
import com.example.Pitlance.Models.ValidResponse.DaDataResponse;
import com.example.Pitlance.Repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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

    public SellerCompanyNameEmailPhoneTPIBalance save(SellerEmailPhonePasswordTPI sellerEmailPhonePasswordTPI){
        DaDataResponse daDataResponse = sellerApiConnector.validateSellerByTPI(sellerEmailPhonePasswordTPI.taxPayerId());
        Seller seller = new Seller(
                daDataResponse.companyName(),
                daDataResponse.sellerName(),
                daDataResponse.sellerLastName(),
                sellerEmailPhonePasswordTPI.email(),
                sellerEmailPhonePasswordTPI.phoneNumber(),
                sellerEmailPhonePasswordTPI.taxPayerId(),
                BigDecimal.ZERO,
                sellerEmailPhonePasswordTPI.password()
                );
        seller.setPassword(passwordEncoder.encode(seller.getPassword()));
        return SellerCompanyNameEmailPhoneTPIBalance.of(sellerRepository.save(seller));
    }

    public Seller getSellerByTPI(String taxPayerId){
        return sellerRepository.getSellerByTaxPayerId(taxPayerId).orElseThrow();
    }

}
