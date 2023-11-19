package com.tracing.distrbuted.Child.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ChildService {
    private final RestTemplate restTemplate;
    private static final String GRANDCHILD_SERVICE_URI = "http://localhost:5050/grandchild-svc/grandchild";

    public ChildService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String callGrandChildService() {
        log.info("Inside ChildService");
        log.info("Calling the GrandChild-SVC from Child-SVC");
        ResponseEntity<String> responseFromGrandChild = restTemplate.exchange(
                GRANDCHILD_SERVICE_URI,
                HttpMethod.GET,
                null,
                String.class
        );
        return responseFromGrandChild.getBody();
    }
}
