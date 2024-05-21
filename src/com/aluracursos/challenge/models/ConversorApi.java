package com.aluracursos.challenge.models;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorApi {
    public Moneda conversor(String currentCurrency, String expectedCurrency, double expectedValue) {
        HttpClient client = HttpClient.newHttpClient();
        URI url_request = URI.create("https://v6.exchangerate-api.com/v6/40bbed2ae68f9891dde300da/pair/" + currentCurrency + "/" + expectedCurrency + "/" + expectedValue);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url_request)
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (IOException | InterruptedException  e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
