package com.gp.currencyexchange.service;

import com.gp.currencyexchange.dto.response.*;

import java.util.List;

public interface ExchangeService {

    LatestDto getLatest(String base);

    ConversionDto convert(String base, String target, String amount);

    LatestDto getHistoricalExchangeRate(String base, String year, String month, String day);

    List<ImageDto> getImageDtos();

    CompareDto getCompareDto(String base, String target1, String target2);

    RatesResponseDto getRates(String base , List<String> target);
}
