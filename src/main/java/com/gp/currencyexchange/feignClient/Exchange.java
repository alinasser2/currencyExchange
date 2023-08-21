package com.gp.currencyexchange.feignClient;


import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "exchange", url = "http://api.exchangeratesapi.io/v1")
@Headers("access_key: 6a4ba7a38cf260b1a276fc669529a954")
public interface Exchange {
    String API_KEY = "6a4ba7a38cf260b1a276fc669529a954";


    /* i cant access this end point because it is not free*/

//     @GetMapping("/convert?access_key={API_KEY}&from={from}&to={to}&amount={amount}")
//     String getExchangeRate(@PathVariable("API_KEY") String apiKey,
//                            @PathVariable("from") String from,
//                            @PathVariable("to") String to,
//                            @PathVariable("amount") String amount);

     @GetMapping("/latest?access_key=6a4ba7a38cf260b1a276fc669529a954&format=1")
        String getLatestExchangeRate();
}
