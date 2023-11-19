package com.tracing.distrbuted.grand.child.controller;

import com.tracing.distrbuted.grand.child.service.GrandChildService;
import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class GrandChildController {
    private final GrandChildService grandChildService;

    @GetMapping("/grandchild")
    @Observed(
            name = "user.name",
            contextualName = "GrandChild-SVC",
            lowCardinalityKeyValues = {"userType","userType2"}
    )
    public String sayHello(){
        log.info("GrandChild is Called - sayHello - Method");
        return grandChildService.createHelloText();
    }
}
