package com.company.journalApp.services;

import com.company.journalApp.api.dummy.DemoAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExternalApiService {
    private static final String apiKey = "anykey-you-want233";
    private static final String API = "the-endpoint-of-api";

    @Autowired
    private RestTemplate restTemplate;

    public DemoAPI getAPIresponse(){
        String apiTocall = "your-final-api-with-API-key-and-any-parameter";
        ResponseEntity<DemoAPI> response = restTemplate.exchange(apiTocall, HttpMethod.GET, null, DemoAPI.class);
        DemoAPI body = response.getBody();
        return body;
    }
}
