package com.winner.controller;

import com.winner.dto.Lotery;
import com.winner.service.WinnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/winner")
@Slf4j
public class WinnerController {
    private WinnerService winnerService;

    public WinnerController(WinnerService winnerService) {
        this.winnerService = winnerService;
    }

    @PostMapping("/")
    public Lotery<Set<Integer>> save(@RequestBody Lotery<Object> lotery){
        log.info("Inside WinnerController::save ");
        return winnerService.save(lotery);
    }
    @GetMapping("/{num}")
    public boolean checkNumber(@PathVariable("num") int num){
        log.info("Inside WinnerController::checkNumber ");
        return winnerService.checkNumber(num);
    }
}
