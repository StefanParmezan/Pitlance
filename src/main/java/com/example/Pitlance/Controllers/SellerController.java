package com.example.Pitlance.Controllers;

import com.example.Pitlance.Models.SellerModelAndDTO.SellerCompanyNameEmailPhoneTPIBalance;
import com.example.Pitlance.Models.SellerModelAndDTO.SellerEmailPhonePasswordTPI;
import com.example.Pitlance.Models.SellerModelAndDTO.SellerNameEmailBalancePhonePasswordTPI;
import com.example.Pitlance.Services.SellerService;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/seller")
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping
    public ResponseEntity<SellerCompanyNameEmailPhoneTPIBalance> save(@RequestBody SellerEmailPhonePasswordTPI sellerEmailPhonePasswordTPI){
        System.out.println(sellerEmailPhonePasswordTPI);
        return ResponseEntity.ok(sellerService.save(sellerEmailPhonePasswordTPI));
    }
}

