package com.gp.currencyexchange.mapper;

import com.gp.currencyexchange.feignresponse.CurrenciesFeignResponse;
import com.gp.currencyexchange.web.response.CurrenciesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CurrenciesMapper {

    @Mapping(source = "base_code", target = "baseCode")
    @Mapping(source = "conversion_rates", target = "conversionRates")
    CurrenciesResponse mapToResponse(CurrenciesFeignResponse feignResponse);
}
