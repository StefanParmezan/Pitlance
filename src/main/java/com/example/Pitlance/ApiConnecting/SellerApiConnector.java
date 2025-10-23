package com.example.Pitlance.ApiConnecting;

import com.example.Pitlance.Models.SellerModelAndDTO.SellerEmailPhonePasswordTPI;
import com.example.Pitlance.Models.SellerModelAndDTO.SellerNameEmailBalancePhonePasswordTPI;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

public class SellerApiConnector {
    private final RestClient restClient = RestClient.create("https://suggestions.dadata.ru/suggestions/api/4_1/rs/findById/party");

    public SellerNameEmailBalancePhonePasswordTPI validateSellerByTPI(SellerEmailPhonePasswordTPI sellerEmailPhonePasswordTPI) {

        Map<String, Object> response = restClient.post()
                .header("Authorization", "Token df9c9b7b020887e03d8aa2c1e1ab5fcbd2608b53")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Map.of(
                        "query", sellerEmailPhonePasswordTPI.taxPayerId(),
                        "count", 1,
                        "type", "INDIVIDUAL"
                ))
                .retrieve()
                .body(new ParameterizedTypeReference<Map<String, Object>>() {});

        List<Map<String, Object>> suggestions = (List<Map<String, Object>>) response.get("suggestions");

        if (suggestions == null || suggestions.isEmpty()) {
            throw new RuntimeException("No IP suggestions found for INN: " + sellerEmailPhonePasswordTPI.taxPayerId());
        }

        Map<String, Object> firstSuggestion = suggestions.get(0);
        Map<String, Object> data = (Map<String, Object>) firstSuggestion.get("data");

        // Для ИП ФИО находится в data.fio
        Map<String, Object> fio = data != null ? (Map<String, Object>) data.get("fio") : null;

        String value = (String) firstSuggestion.get("value");
        String name = fio != null ? (String) fio.get("name") : null;
        String surname = fio != null ? (String) fio.get("surname") : null;

        SellerNameEmailBalancePhonePasswordTPI seller = new SellerNameEmailBalancePhonePasswordTPI(
                value,
                name,
                surname,
                sellerEmailPhonePasswordTPI.email(),
                sellerEmailPhonePasswordTPI.phone(),
                sellerEmailPhonePasswordTPI.taxPayerId(),
                0,
                sellerEmailPhonePasswordTPI.password()
        );

        System.out.println(seller);
        return seller;
    }
}