package com.gp.currencyexchange.web.controller;

import com.gp.currencyexchange.web.dto.ImageDto;
import com.gp.currencyexchange.exception.customize.CustomException;
import com.gp.currencyexchange.web.response.CurrenciesResponse;
import com.gp.currencyexchange.web.response.CurrencyPreferencesResponse;
import com.gp.currencyexchange.web.response.CurrencyConversionResponse;
import com.gp.currencyexchange.web.response.CurrencyComparisonResponse;
import com.gp.currencyexchange.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CurrencyExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @GetMapping("/latest/{base}")
    public ResponseEntity<CurrenciesResponse> getLatestExchangeRates(@PathVariable String base) throws CustomException {
//        return ResponseEntity.ok(exchangeService.getLatest(base));
        return ResponseEntity.status(HttpStatus.OK.value()).body(exchangeService.getLatest(base));
    }

    @GetMapping("/pair/{base}/{target}/{amount}")
    public ResponseEntity<CurrencyConversionResponse> convertCurrency(@PathVariable String base, @PathVariable String target, @PathVariable String amount) throws CustomException {
        return ResponseEntity.status(HttpStatus.OK.value()).body(exchangeService.convert(base, target, amount));
    }

    @GetMapping("/history/{base}/{year}/{month}/{day}")
    public ResponseEntity<CurrenciesResponse> getHistoricalExchangeRates(@PathVariable String base, @PathVariable String year, @PathVariable String month, @PathVariable String day) throws CustomException {
        return ResponseEntity.status(HttpStatus.OK.value()).body(exchangeService.getHistoricalExchangeRate(base, year, month, day));
    }

    @GetMapping("/images")
    public ResponseEntity<List<ImageDto>> getCurrenciesFlags() {
        return ResponseEntity.status(HttpStatus.OK.value()).body(exchangeService.getImageDtos());
    }

    @GetMapping("/compare/{base}/{first_target}/{second_target}/{amount}")
    ResponseEntity<CurrencyComparisonResponse> compareTwoCurrencies(@PathVariable String base, @PathVariable String first_target, @PathVariable String second_target, @PathVariable String amount) throws CustomException {
        return ResponseEntity.status(HttpStatus.OK.value()).body(exchangeService.getCompareDto(base, first_target, second_target, amount));
    }

    @GetMapping("/rates")
    ResponseEntity<CurrencyPreferencesResponse> compareManyCurrencies(@RequestParam String base_code,@RequestParam List<String> targets) throws CustomException {
        return ResponseEntity.status(HttpStatus.OK.value()).body(exchangeService.getRates(base_code, targets));
    }

}
