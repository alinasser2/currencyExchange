package com.gp.currencyexchange.service;

import com.gp.currencyexchange.dto.*;
import com.gp.currencyexchange.dto.ImageDto;
import com.gp.currencyexchange.response.CurrenciesResponse;
import com.gp.currencyexchange.response.CurrencyPreferencesResponse;
import com.gp.currencyexchange.response.CurrencyConversionResponse;
import com.gp.currencyexchange.response.CurrencyComparisonResponse;

import java.util.List;

public interface ExchangeService {

    CurrenciesResponse getLatest(String base);

    CurrencyConversionResponse convert(String base, String target, String amount);

    CurrenciesResponse getHistoricalExchangeRate(String base, String year, String month, String day);

    List<ImageDto> getImageDtos();

    CurrencyComparisonResponse getCompareDto(String base, String target1, String target2, String amount);

    CurrencyPreferencesResponse getRates(String base_code, List<String> targets);

    public String clearCache();
}
