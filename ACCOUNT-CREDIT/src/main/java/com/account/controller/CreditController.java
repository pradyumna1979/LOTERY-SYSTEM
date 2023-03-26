package com.account.controller;

import com.account.entity.Account;
import com.account.dto.RequestObject;
import com.account.entity.User;
import com.account.service.CreditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/credit")
public class CreditController {
    CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @PutMapping("/")
    public String credit(@RequestBody RequestObject request){
        log.info("Inside CreditController::credit "+request);
        return creditService.credit(request);
    }

}
