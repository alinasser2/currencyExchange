package com.gp.currencyexchange.service;

import com.gp.currencyexchange.dto.response.CompareDto;
import com.gp.currencyexchange.dto.response.ImageDto;
import com.gp.currencyexchange.dto.response.LatestDto;
import com.gp.currencyexchange.dto.response.ConversionDto;

import java.util.List;

public interface ExchangeService {

    LatestDto getLatest(String base);

    ConversionDto convert(String base, String target, String amount);

    LatestDto getHistoricalExchangeRate(String base, String year, String month, String day);

    List<ImageDto> getImageDtos();

    CompareDto getCompareDto(String base, String target1, String target2);

}