package com.gp.currencyexchange;

import com.gp.currencyexchange.enums.Currencies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
//@PropertySource("classpath:application.properties")
@EnableCaching
public class CurrencyExchangeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CurrencyExchangeApplication.class, args);
    }
}
