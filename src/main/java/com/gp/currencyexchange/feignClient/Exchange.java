package com.gp.currencyexchange.feignClient;


import com.gp.currencyexchange.feignresponse.CurrenciesFeignResponse;
import com.gp.currencyexchange.feignresponse.CurrencyConversionFeignResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "exchange", url ="${exchange.url}")
public interface Exchange {

    @GetMapping("/latest/{base}")
    CurrenciesFeignResponse getLatestExchangeRate(@PathVariable String base);

    @GetMapping("/pair/{base}/{target}")
    CurrencyConversionFeignResponse getPairExchangeRate(@PathVariable String base, @PathVariable String target);

    @GetMapping("/history/{base}/{year}/{month}/{day}")
    CurrenciesFeignResponse getHistoryExchangeRate(@PathVariable String base, @PathVariable String year, @PathVariable String month, @PathVariable String day);
}
