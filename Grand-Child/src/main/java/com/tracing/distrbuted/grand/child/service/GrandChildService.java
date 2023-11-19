package com.tracing.distrbuted.grand.child.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GrandChildService {
    public String createHelloText() {
        log.info("Inside - GrandChild Service");
        return "Hello From the Grand Child Service";
    }
}
