package com.chrisyoo.kafka;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class SkiApiService {

    public String sendRequestToSkiApi() {
        String body = "";
        JSONParser parser = new JSONParser();
        JSONObject dataInJsonFormat = null;
        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(buildRequest(), HttpResponse.BodyHandlers.ofString());
            body = response.body();
            System.out.println(response.body());
        } catch(Exception exception) {
            System.out.println(exception);
        }

        return body;
    }

    private HttpRequest buildRequest() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://ski-resorts-and-conditions.p.rapidapi.com/v1/resort"))
                .header("X-RapidAPI-Key", "0495933f5emsh19af863bbc666d5p1290dbjsn0dd243175962")
                .header("X-RapidAPI-Host", "ski-resorts-and-conditions.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        return request;
    }
}
