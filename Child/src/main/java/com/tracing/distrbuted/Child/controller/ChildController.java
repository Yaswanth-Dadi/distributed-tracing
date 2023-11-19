package com.tracing.distrbuted.Child.controller;

import com.tracing.distrbuted.Child.service.ChildService;
import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ChildController {
    //USe the Rest Template to call the class

    private final ChildService childService;

    @GetMapping("/child")
    @Observed(
            name = "user.name",
            contextualName = "Child-SVC",
            lowCardinalityKeyValues = {"userType","userType2"}
    )
    public String sayHello() {
        log.info("Child service is called");
        return childService.callGrandChildService();
    }

}
