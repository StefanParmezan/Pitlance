package com.example.Pitlance.Services;

import com.example.Pitlance.Models.SellerModelAndDTO.Seller;
import com.example.Pitlance.Models.SellerModelAndDTO.SellerNameEmailBalancePhonePasswordTPI;
import com.example.Pitlance.Repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository){
        this.sellerRepository = sellerRepository;
    }

    public Seller save(SellerNameEmailBalancePhonePasswordTPI sellerNameEmailBalancePhonePasswordTPI){
        return sellerRepository.save(new Seller(
                sellerNameEmailBalancePhonePasswordTPI.sellerName(),
                sellerNameEmailBalancePhonePasswordTPI.email(),
                sellerNameEmailBalancePhonePasswordTPI.phoneNumber(),
                sellerNameEmailBalancePhonePasswordTPI.taxPayerId(),
                sellerNameEmailBalancePhonePasswordTPI.balance(),
                sellerNameEmailBalancePhonePasswordTPI.password()));
    }
}
