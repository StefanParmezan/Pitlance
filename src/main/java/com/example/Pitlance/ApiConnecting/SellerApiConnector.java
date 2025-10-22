package com.example.Pitlance.ApiConnecting;

import com.example.Pitlance.Models.SellerModelAndDTO.SellerEmailPhonePasswordTPI;
import com.example.Pitlance.Models.SellerModelAndDTO.SellerNameEmailBalancePhonePasswordTPI;

public class SellerApiConnector {
    private static final String taxPayerIdApi = "https://suggestions.dadata.ru/suggestions/api/4_1/rs/findById/party";

    public SellerNameEmailBalancePhonePasswordTPI validateSellerByTPI(SellerEmailPhonePasswordTPI seller){

    }

    public String getTaxPayerIdApi(){
        return taxPayerIdApi;
    }
}
