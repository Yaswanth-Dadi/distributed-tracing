package com.tracing.distrbuted.Parent.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class ParentService {
    private static final String CHILD_SVC_URI = "http://localhost:6060/child-svc/child";
    private final RestTemplate restTemplate;

    public String callChildService() {
        log.info("Inside Parent service");
        log.info("Calling the Child-SVC from the Parent-SVC");
        ResponseEntity<String> responseFromChildService = restTemplate.exchange(
                CHILD_SVC_URI,
                HttpMethod.GET,
                null,
                String.class
        );

        return responseFromChildService.getBody();
    }
}
