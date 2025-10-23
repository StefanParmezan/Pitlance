package com.example.Pitlance;

import com.example.Pitlance.ApiConnecting.SellerApiConnector;
import com.example.Pitlance.Models.SellerModelAndDTO.SellerEmailPhonePasswordTPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {
    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
        SellerApiConnector sellerApiConnector = new SellerApiConnector();
        SellerEmailPhonePasswordTPI s = new SellerEmailPhonePasswordTPI("s", 123, "123", "7707083893");
        System.out.println(sellerApiConnector.validateSellerByTPI(s));
    }
}
