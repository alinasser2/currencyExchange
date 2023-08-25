package com.gp.currencyexchange.controller;

import com.gp.currencyexchange.dto.response.*;
import com.gp.currencyexchange.exception.customize.InvalidCurrencyException;
import com.gp.currencyexchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class currencyExchangeCont {

    private final ExchangeService exchangeService;

    @GetMapping("/latest/{base}")
    public LatestDto getLatestExchangeRate(@PathVariable String base) {
        return exchangeService.getLatest(base);
    }

    @GetMapping("/pair/{base}/{target}/{amount}")
    public ConversionDto getPairExchangeRate(@PathVariable String base, @PathVariable String target, @PathVariable String amount) {
        return exchangeService.convert(base, target, amount);
    }

    @GetMapping("/history/{base}/{year}/{month}/{day}")
    public LatestDto getHistoryExchangeRate(@PathVariable String base, @PathVariable String year, @PathVariable String month, @PathVariable String day) {
        return exchangeService.getHistoricalExchangeRate(base, year, month, day);
    }

    @GetMapping("/images")
    public List<ImageDto> getImages() {
        return exchangeService.getImageDtos();
    }

    @GetMapping("/compare/{base}/{target1}/{target2}")
    CompareDto compare(@PathVariable String base, @PathVariable String target1, @PathVariable String target2) {
        return exchangeService.getCompareDto(base, target1, target2);
    }

    @GetMapping("/rates")
    RatesResponseDto getRates(RatesDto dto) {
        return exchangeService.getRates(dto);
    }

}
