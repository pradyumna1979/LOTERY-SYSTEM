package com.winner.service;

import com.winner.dto.Lotery;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
public class WinnerService {
    private Lotery<Set<Integer>> loteries;

    public Lotery<Set<Integer>> save(Lotery<Object> lotery) {
        log.info("Inside WinnerService::save");
        this.loteries = new Lotery<>();
        this.loteries.setLoteryIds(lotery.getLoteryIds());
        return loteries;
    }

    public boolean checkNumber(int num) {
        log.info("Inside WinnerService::checkNumber");
        return loteries!=null && loteries.getLoteryIds() != null && loteries.getLoteryIds().contains(num);
    }
}
