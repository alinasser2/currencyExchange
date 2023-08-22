package com.gp.currencyexchange.controller;

import com.gp.currencyexchange.dto.response.Latest;
import com.gp.currencyexchange.dto.response.Pair;
import com.gp.currencyexchange.dto.response.SupportedCodes;
import com.gp.currencyexchange.enums.Currencies;
import com.gp.currencyexchange.feignClient.Exchange;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
public class currencyExchangeCont {

    private final Exchange exchange;

    @GetMapping("/latest/{base}")
    public Latest getLatestExchangeRate(@PathVariable String base) {
        return exchange.getLatestExchangeRate(base);
    }

    @GetMapping("/pair/{base}/{target}")
    public Pair getPairExchangeRate(@PathVariable String base, @PathVariable String target) {
        return exchange.getPairExchangeRate(base, target);
    }

    @GetMapping("/history/{base}/{year}/{month}/{day}")
    public Latest getHistoryExchangeRate(@PathVariable String base, @PathVariable String year, @PathVariable String month, @PathVariable String day) {
        return exchange.getHistoryExchangeRate(base, year, month, day);
    }

//    @GetMapping("/codes")
//    public String getCodes() {
//        return exchange.getCodes();
//    }


    @GetMapping("/images")
    public Map<String,String> getImages() {
        return Stream.of(Currencies.values()).collect(HashMap::new, (m, c) -> m.put(c.name(), "https://flagsapi.com/"+ c.getCountry() +"/flat/64.png"), HashMap::putAll);
    }


}
