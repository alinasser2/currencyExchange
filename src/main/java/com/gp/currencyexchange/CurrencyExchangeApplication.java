package com.gp.currencyexchange;

import com.gp.currencyexchange.enums.Currencies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class CurrencyExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyExchangeApplication.class, args);
    }

}
