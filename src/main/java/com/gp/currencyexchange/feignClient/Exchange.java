package com.gp.currencyexchange.feignClient;


import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "exchange", url = "https://api.exchangeratesapi.io/v1")
@Headers("access_key: 6a4ba7a38cf260b1a276fc669529a954")
public interface Exchange {

    String API_KEY = "6a4ba7a38cf260b1a276fc669529a954";

     @GetMapping("/convert?access_key={API_KEY}&from={from}&to={to}&amount={amount}")
     String getExchangeRate(@RequestParam("access_key") String apiKey,
                            @RequestParam("from") String from,
                            @RequestParam("to") String to,
                            @RequestParam("amount") String amount);
}
