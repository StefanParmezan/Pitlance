package com.example.Pitlance.ApiConnecting;

import com.example.Pitlance.Models.ValidResponse.DaDataResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

@Service
public class SellerApiConnector {
    private final RestClient restClient = RestClient.create("https://suggestions.dadata.ru/suggestions/api/4_1/rs/findById/party");

    public SellerApiConnector(@Value("${dadata.api.secretkey}") String daDataSecretKey){
        this.daDataSecreyKey = daDataSecretKey;
    }

    private final String daDataSecreyKey;

    public DaDataResponse validateSellerByTPI(String taxPayerId) {

        DaDataApiResponse response = restClient.post()
                .header("Authorization", "Token " + daDataSecreyKey)
                .body(new DaDataRequest(taxPayerId, 1, "INDIVIDUAL"))
                .retrieve()
                .body(DaDataApiResponse.class);

        if (response.suggestions() == null || response.suggestions().isEmpty()) {
            throw new RuntimeException("No IP suggestions found for INN: " + taxPayerId);
        }

        System.out.println(response);
        Suggestion firstSuggestion = response.suggestions().get(0);
        Data data = firstSuggestion.data();
        Fio fio = data.fio();
        System.out.println("companyName: " + firstSuggestion.value + "\nname: " + fio.name + "\nlastname: " + fio.surname);



        return new DaDataResponse(
                firstSuggestion.value,
                fio.name.orElseThrow(),
                fio.surname.orElseThrow()
        );
    }

    public record DaDataApiResponse(List<Suggestion> suggestions) {
        @Override
        public String toString() {
            return "DaDataApiResponse{" +
                    "suggestions=" + suggestions +
                    '}';
        }
    }

    public record Suggestion(String value, Data data) {
        @Override
        public String toString() {
            return "Suggestion{" +
                    "value='" + value + '\'' +
                    ", data=" + data +
                    '}';
        }
    }

    public record Data(Fio fio) {
        @Override
        public String toString() {
            return "Data{" +
                    "fio=" + fio +
                    '}';
        }
    }

    public record Fio(Optional<String> surname, Optional<String> name) {
        @Override
        public String toString() {
            return "Fio{" +
                    "surname='" + surname + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public record DaDataRequest(String query, int count, String type){}


}