package com.example.Pitlance.ApiConnecting;

import com.example.Pitlance.Models.ValidResponse.DaDataResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class SellerApiConnector {
    private final RestClient restClient = RestClient.create("https://suggestions.dadata.ru/suggestions/api/4_1/rs/findById/party");

    public DaDataResponse validateSellerByTPI(String taxPayerId) {

        DaDataApiResponse response = restClient.post()
                .header("Authorization", "Token df9c9b7b020887e03d8aa2c1e1ab5fcbd2608b53")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new DaDataRequest(taxPayerId, 1, "INDIVIDUAL"))
                .retrieve()
                .body(DaDataApiResponse.class);

        if (response.suggestions() == null || response.suggestions().isEmpty()) {
            throw new RuntimeException("No IP suggestions found for INN: " + taxPayerId);
        }

        Suggestion firstSuggestion = response.suggestions().get(0);

        return new DaDataResponse(
                firstSuggestion.value,
                firstSuggestion.data.fio.name,
                firstSuggestion.data.fio.lastName
        );
    }

    public record DaDataApiResponse(List<Suggestion> suggestions) {}

    public record Suggestion(String value, Data data) {}

    public record Data(Fio fio) {}

    public record Fio(String lastName, String name) {}

    public record DaDataRequest(String query, int count, String type){}


}