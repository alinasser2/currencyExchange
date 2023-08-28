package com.gp.currencyexchange.mapper;

import com.gp.currencyexchange.web.dto.CurrencyConversionDto;
import com.gp.currencyexchange.feignresponse.CurrencyConversionFeignResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CurrencyConversionMapper {

    @Mapping(source = "baseCode" , target = "base_code")
    @Mapping(source = "targetCode" , target = "target_code")
    @Mapping(source = "conversionRate" , target = "conversion_rate")
    CurrencyConversionFeignResponse mapToFeignResponse(CurrencyConversionDto response);

    @Mapping(source = "base_code" , target = "baseCode")
    @Mapping(source = "target_code" , target = "targetCode")
    @Mapping(source = "conversion_rate" , target = "conversionRate")
    CurrencyConversionDto mapToDto(CurrencyConversionFeignResponse feignResponse);
}
