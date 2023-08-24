package com.gp.currencyexchange.feignClient;


import com.gp.currencyexchange.dto.response.LatestDto;
import com.gp.currencyexchange.dto.response.ConversionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "exchange", url = "https://v6.exchangerate-api.com/v6/${access_key}")
public interface Exchange {

    @GetMapping("/latest/{base}")
    LatestDto getLatestExchangeRate(@PathVariable String base);

    @GetMapping("/pair/{base}/{target}")
    ConversionDto getPairExchangeRate(@PathVariable String base, @PathVariable String target);

    @GetMapping("/history/{base}/{year}/{month}/{day}")
    LatestDto getHistoryExchangeRate(@PathVariable String base, @PathVariable String year, @PathVariable String month, @PathVariable String day);

    @GetMapping("/codes")
    String getCodes();
}
