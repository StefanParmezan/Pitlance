package com.example.Pitlance.ApiConnecting;

import com.example.Pitlance.Models.SellerModelAndDTO.SellerEmailPhonePasswordTPI;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

public class SellerApiConnector {
    private final RestClient restClient = RestClient.create("https://suggestions.dadata.ru/suggestions/api/4_1/rs/findById/party");

    public String validateSellerByTPI(SellerEmailPhonePasswordTPI sellerEmailPhonePasswordTPI) {
        String requestBody = """
            {
                "query": "7707083893"
            }
            """;

        return restClient.post()
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "Token df9c9b7b020887e03d8aa2c1e1ab5fcbd2608b53")
                .body(requestBody)
                .retrieve()
                .body(String.class);
    }
}