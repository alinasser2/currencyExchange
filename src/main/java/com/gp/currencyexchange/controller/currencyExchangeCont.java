package com.gp.currencyexchange.controller;

import com.gp.currencyexchange.feignClient.Exchange;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class currencyExchangeCont {

    private final Exchange exchange;

    @GetMapping("/latest/{base}")
    public String getLatestExchangeRate(@PathVariable String base) {
        return exchange.getLatestExchangeRate(base);
    }

    @GetMapping("/pair/{base}/{target}")
    public String getPairExchangeRate(@PathVariable String base, @PathVariable String target) {
        return exchange.getPairExchangeRate(base, target);
    }

    @GetMapping("/history/{base}/{year}/{month}/{day}")
    public String getHistoryExchangeRate(@PathVariable String base, @PathVariable String year, @PathVariable String month, @PathVariable String day) {
        return exchange.getHistoryExchangeRate(base, year, month, day);
    }

    @GetMapping("/codes")
    public String getCodes() {
        return exchange.getCodes();
    }



}
