package com.gp.currencyexchange.feignClient;


import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "exchange", url = "https://v6.exchangerate-api.com/v6/${access_key}")
@Headers("access_key: ecf10bab01b34bf0de9636e1")
public interface Exchange {

    @GetMapping("/latest/{base}")
    String getLatestExchangeRate(@PathVariable String base);

    @GetMapping("/pair/{base}/{target}")
    String getPairExchangeRate(@PathVariable String base, @PathVariable String target);

    @GetMapping("/history/{base}/{year}/{month}/{day}")
    String getHistoryExchangeRate(@PathVariable String base, @PathVariable String year, @PathVariable String month, @PathVariable String day);

    @GetMapping("/codes")
    String getCodes();




}
