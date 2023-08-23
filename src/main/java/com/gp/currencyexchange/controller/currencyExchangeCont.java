package com.gp.currencyexchange.controller;

import com.gp.currencyexchange.dto.response.*;
import com.gp.currencyexchange.enums.Currencies;
import com.gp.currencyexchange.feignClient.Exchange;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
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
    public List<ImageDto> getImages() {
        // loop over the currencies enum and create a list of ImageDto
        // each ImageDto should have the name of the currency and the url of the image
        List<ImageDto> result = new ArrayList<>();
        Stream.of(Currencies.values()).forEach(c -> result.add(new ImageDto(c.name(), "https://flagsapi.com/"+ c.getCountry() +"/flat/64.png")));
        return result;
    }

    @GetMapping("/compare/{base}/{target1}/{target2}")
    CompareDto getPairExchangeRate(@PathVariable String base, @PathVariable String target1, @PathVariable String target2) {
        Latest latest = exchange.getLatestExchangeRate(base);
        return new CompareDto(base,target1,target2,latest.getConversion_rates().get(target1),latest.getConversion_rates().get(target2));
    }




}
