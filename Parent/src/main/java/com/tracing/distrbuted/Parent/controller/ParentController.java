package com.tracing.distrbuted.Parent.controller;

import com.tracing.distrbuted.Parent.service.ParentService;
import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ParentController {
    private final ParentService parentService;

    @GetMapping("parent")
    @Observed(
            name = "user.name",
            contextualName = "Parent-SVC",
            lowCardinalityKeyValues = {"userType","userType2"}
    )
    public String sayHello() {
        log.info("Parent was called");
        return parentService.callChildService();
    }
}
