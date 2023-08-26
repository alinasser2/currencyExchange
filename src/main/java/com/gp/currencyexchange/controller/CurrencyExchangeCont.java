package com.gp.currencyexchange.controller;

import com.gp.currencyexchange.dto.*;
import com.gp.currencyexchange.dto.ImageDto;
import com.gp.currencyexchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CurrencyExchangeCont {

    private final ExchangeService exchangeService;

    @GetMapping("/latest/{base}")
    public ResponseEntity<AllCurrExchangeDto> getLatestExchangeRates(@PathVariable String base) {
        return ResponseEntity.ok(exchangeService.getLatest(base));
    }

    @GetMapping("/pair/{base}/{target}/{amount}")
    public ResponseEntity<OneCurrExchangeDto> convertCurrency(@PathVariable String base, @PathVariable String target, @PathVariable String amount) {
        return ResponseEntity.ok(exchangeService.convert(base, target, amount));
    }

    @GetMapping("/history/{base}/{year}/{month}/{day}")
    public ResponseEntity<AllCurrExchangeDto> getHistoricalExchangeRates(@PathVariable String base, @PathVariable String year, @PathVariable String month, @PathVariable String day) {
        return ResponseEntity.ok(exchangeService.getHistoricalExchangeRate(base, year, month, day));
    }

    @GetMapping("/images")
    public ResponseEntity<List<ImageDto>> getCurrenciesFlags() {
        return ResponseEntity.ok(exchangeService.getImageDtos());
    }

    @GetMapping("/compare/{base}/{first_target}/{second_target}/{amount}")
    ResponseEntity<TwoCurrExchangeDto> compareTwoCurrencies(@PathVariable String base, @PathVariable String first_target, @PathVariable String second_target, @PathVariable String amount) {
        return ResponseEntity.ok(exchangeService.getCompareDto(base, first_target, second_target, amount));
    }

    @GetMapping("/rates")
    ResponseEntity<ManyCurrExchangeResDto> compareManyCurrencies(ManyCurrExchangeReqDto dto) {
        return ResponseEntity.ok(exchangeService.getRates(dto));
    }

}
