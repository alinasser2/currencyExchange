package com.gp.currencyexchange.service;

import com.gp.currencyexchange.dto.ImageDto;
import com.gp.currencyexchange.exception.customize.CustomException;
import com.gp.currencyexchange.web.response.CurrenciesResponse;
import com.gp.currencyexchange.web.response.CurrencyPreferencesResponse;
import com.gp.currencyexchange.web.response.CurrencyConversionResponse;
import com.gp.currencyexchange.web.response.CurrencyComparisonResponse;

import java.util.List;

public interface ExchangeService {

    CurrenciesResponse getLatest(String base) throws CustomException;

    CurrencyConversionResponse convert(String base, String target, String amount) throws CustomException;

    CurrenciesResponse getHistoricalExchangeRate(String base, String year, String month, String day) throws CustomException;

    List<ImageDto> getImageDtos();

    CurrencyComparisonResponse getCompareDto(String base, String target1, String target2, String amount) throws CustomException;

    CurrencyPreferencesResponse getRates(String base_code, List<String> targets) throws CustomException;

    public void clearCache();
}
