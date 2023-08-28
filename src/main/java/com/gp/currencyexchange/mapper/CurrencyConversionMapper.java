package com.gp.currencyexchange.mapper;

import com.gp.currencyexchange.feignresponse.CurrencyConversionFeignResponse;
import com.gp.currencyexchange.web.response.CurrencyConversionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CurrencyConversionMapper {

    @Mapping(source = "conversion_rate" , target = "conversionRate")
    CurrencyConversionResponse mapToResponse(CurrencyConversionFeignResponse feignResponse);
}
