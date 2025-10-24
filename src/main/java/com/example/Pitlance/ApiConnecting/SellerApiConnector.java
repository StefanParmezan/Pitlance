package com.example.Pitlance.ApiConnecting;

import com.example.Pitlance.Models.SellerModelAndDTO.SellerEmailPhonePasswordTPI;
import com.example.Pitlance.Models.SellerModelAndDTO.SellerNameEmailBalancePhonePasswordTPI;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class SellerApiConnector {
    private final RestClient restClient = RestClient.create("https://suggestions.dadata.ru/suggestions/api/4_1/rs/findById/party");

    public SellerNameEmailBalancePhonePasswordTPI validateSellerByTPI(SellerEmailPhonePasswordTPI sellerEmailPhonePasswordTPI) {

        DaDataResponse response = restClient.post()
                .header("Authorization", "Token df9c9b7b020887e03d8aa2c1e1ab5fcbd2608b53")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Map.of(
                        "query", sellerEmailPhonePasswordTPI.taxPayerId(),
                        "count", 1,
                        "type", "INDIVIDUAL"
                ))
                .retrieve()
                .body(DaDataResponse.class);

        if (response.suggestions() == null || response.suggestions().isEmpty()) {
            throw new RuntimeException("No IP suggestions found for INN: " + sellerEmailPhonePasswordTPI.taxPayerId());
        }

        Suggestion firstSuggestion = response.suggestions().get(0);
        Data data = firstSuggestion.data();
        Fio fio = data.fio();

        SellerNameEmailBalancePhonePasswordTPI seller = new SellerNameEmailBalancePhonePasswordTPI(
                firstSuggestion.value(),
                fio.name(),
                fio.surname(),
                sellerEmailPhonePasswordTPI.email(),
                sellerEmailPhonePasswordTPI.phone(),
                sellerEmailPhonePasswordTPI.taxPayerId(),
                0,
                sellerEmailPhonePasswordTPI.password()
        );

        System.out.println(seller);
        return seller;
    }

    public record DaDataResponse(List<Suggestion> suggestions) {}

    public record Suggestion(String value, Data data) {}

    public record Data(Fio fio) {}

    public record Fio(String surname, String name, String patronymic) {}
}