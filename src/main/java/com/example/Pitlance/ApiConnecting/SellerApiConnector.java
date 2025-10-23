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

        String rawResponse = restClient.post()
                .header("Authorization", "Token df9c9b7b020887e03d8aa2c1e1ab5fcbd2608b53")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Map.of("query", sellerEmailPhonePasswordTPI.taxPayerId()))
                .retrieve()
                .body(String.class);

        System.out.println("RAW RESPONSE: " + rawResponse);

        Map<String, Object> response = restClient.post()
                .header("Authorization", "Token df9c9b7b020887e03d8aa2c1e1ab5fcbd2608b53")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Map.of("query", sellerEmailPhonePasswordTPI.taxPayerId()))
                .retrieve()
                .body(new ParameterizedTypeReference<Map<String, Object>>() {});

        // Отладочная информация - посмотрим что пришло
        System.out.println("Response keys: " + response.keySet());

        List<Map<String, Object>> suggestions = (List<Map<String, Object>>) response.get("suggestions");
        System.out.println("Suggestions size: " + (suggestions != null ? suggestions.size() : 0));

        if (suggestions != null && !suggestions.isEmpty()) {
            Map<String, Object> firstSuggestion = suggestions.get(0);
            System.out.println("First suggestion keys: " + firstSuggestion.keySet());

            // Безопасное извлечение данных
            String value = extractString(firstSuggestion, "value");
            Map<String, Object> data = (Map<String, Object>) firstSuggestion.get("data");

            if (data != null) {
                System.out.println("Data keys: " + data.keySet());
                String name = extractString(data, "name");
                String fullName = extractString(data, "full_name");
                String shortName = extractString(data, "short_name");

                // Используем полученные данные
                SellerNameEmailBalancePhonePasswordTPI seller = new SellerNameEmailBalancePhonePasswordTPI(
                        value,
                        name != null ? name : fullName != null ? fullName : shortName,
                        null, // фамилия
                        sellerEmailPhonePasswordTPI.email(),
                        sellerEmailPhonePasswordTPI.phone(),
                        sellerEmailPhonePasswordTPI.taxPayerId(),
                        0,
                        sellerEmailPhonePasswordTPI.password()
                );
                return seller;
            }
        }

        throw new RuntimeException("No valid data found for TPI: " + sellerEmailPhonePasswordTPI.taxPayerId());
    }

    // Вспомогательный метод для безопасного извлечения строк
    private String extractString(Map<String, Object> map, String key) {
        Object value = map.get(key);
        return value instanceof String ? (String) value : null;
    }
}