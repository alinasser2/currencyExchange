package com.gp.currencyexchange.service;

import com.gp.currencyexchange.dto.*;
import com.gp.currencyexchange.dto.ImageDto;

import java.util.List;

public interface ExchangeService {

    AllCurrExchangeDto getLatest(String base);

    OneCurrExchangeDto convert(String base, String target, String amount);

    AllCurrExchangeDto getHistoricalExchangeRate(String base, String year, String month, String day);

    List<ImageDto> getImageDtos();

    TwoCurrExchangeDto getCompareDto(String base, String target1, String target2, String amount);

    ManyCurrExchangeResDto getRates(ManyCurrExchangeReqDto dto);
}
