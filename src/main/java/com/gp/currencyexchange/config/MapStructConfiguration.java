package com.gp.currencyexchange.config;

import com.gp.currencyexchange.mapper.CurrenciesMapper;
import com.gp.currencyexchange.mapper.CurrenciesMapperImpl;
import com.gp.currencyexchange.mapper.CurrencyConversionMapper;
import com.gp.currencyexchange.mapper.CurrencyConversionMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapStructConfiguration {

    @Bean
    public CurrenciesMapper CurrenciesMapper() {
        return new CurrenciesMapperImpl();
    }


    @Bean
    public CurrencyConversionMapper CurrencyConversionMapper() {
        return new CurrencyConversionMapperImpl();
    }

}
