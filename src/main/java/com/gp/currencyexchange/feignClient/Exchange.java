package com.gp.currencyexchange.feignClient;


import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "exchange", url = "https://api.exchangeratesapi.io/v1")
@Headers("access_key: 6a4ba7a38cf260b1a276fc669529a954")
public interface Exchange {
    String API_KEY = "6a4ba7a38cf260b1a276fc669529a954";

     @GetMapping("/convert?access_key={API_KEY}&from={from}&to={to}&amount={amount}")
     String getExchangeRate(@PathVariable("API_KEY") String apiKey,
                            @PathVariable("from") String from,
                            @PathVariable("to") String to,
                            @PathVariable("amount") String amount);
}
