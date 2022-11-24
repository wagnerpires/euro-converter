package com.currency.euro.controllers;

import com.currency.euro.entities.Euro;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EuroController {

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${api.uri}")
    private String uri;

    @GetMapping(value = "/euro", produces = "application/json")
    public ResponseEntity<List<Euro>> getEuroClient() throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        String getEuro = restTemplate.getForObject(uri, String.class);
        List<Euro> euro = objectMapper.readValue(getEuro, new TypeReference<ArrayList<Euro>>(){});

        return ResponseEntity.ok().body(euro);
    }
}
