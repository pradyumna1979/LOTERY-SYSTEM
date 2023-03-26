package com.gateway.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FallBackController {
    @GetMapping("/WINNER-fallback")
    public String winnerFallback() {
        log.info("inside FallBackController::winnerFallback");
        return "Something is wrong !! try later";
    }
}
