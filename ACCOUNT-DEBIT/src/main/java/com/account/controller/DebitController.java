package com.account.controller;

import com.account.dto.DebitRequestObject;
import com.account.service.DebitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/debit")
public class DebitController {
    DebitService debitService;

    public DebitController(DebitService debitService) {
        this.debitService = debitService;
    }

    @PutMapping("/")
    public String debit(@RequestBody DebitRequestObject request){
        log.info("Inside DebitController::credit "+request);
        return debitService.debit(request);
    }
}
