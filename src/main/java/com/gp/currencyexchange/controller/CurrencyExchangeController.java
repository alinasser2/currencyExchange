package com.gp.currencyexchange.controller;

import com.gp.currencyexchange.dto.ImageDto;
import com.gp.currencyexchange.response.CurrenciesResponse;
import com.gp.currencyexchange.response.CurrencyPreferencesResponse;
import com.gp.currencyexchange.response.CurrencyConversionResponse;
import com.gp.currencyexchange.response.CurrencyComparisonResponse;
import com.gp.currencyexchange.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CurrencyExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @GetMapping("/latest/{base}")
    public ResponseEntity<CurrenciesResponse> getLatestExchangeRates(@PathVariable String base) {
        return ResponseEntity.ok(exchangeService.getLatest(base));
    }

    @GetMapping("/pair/{base}/{target}/{amount}")
    public ResponseEntity<CurrencyConversionResponse> convertCurrency(@PathVariable String base, @PathVariable String target, @PathVariable String amount) {
        return ResponseEntity.ok(exchangeService.convert(base, target, amount));
    }

    @GetMapping("/history/{base}/{year}/{month}/{day}")
    public ResponseEntity<CurrenciesResponse> getHistoricalExchangeRates(@PathVariable String base, @PathVariable String year, @PathVariable String month, @PathVariable String day) {
        return ResponseEntity.ok(exchangeService.getHistoricalExchangeRate(base, year, month, day));
    }

    @GetMapping("/images")
    public ResponseEntity<List<ImageDto>> getCurrenciesFlags() {
        return ResponseEntity.ok(exchangeService.getImageDtos());
    }

    @GetMapping("/compare/{base}/{first_target}/{second_target}/{amount}")
    ResponseEntity<CurrencyComparisonResponse> compareTwoCurrencies(@PathVariable String base, @PathVariable String first_target, @PathVariable String second_target, @PathVariable String amount) {
        return ResponseEntity.ok(exchangeService.getCompareDto(base, first_target, second_target, amount));
    }

    @GetMapping("/rates")
    ResponseEntity<CurrencyPreferencesResponse> compareManyCurrencies(@RequestParam String base_code,@RequestParam List<String> targets) {
        return ResponseEntity.ok(exchangeService.getRates(base_code, targets));
    }

}
