package com.gp.currencyexchange.service.serviceImpl;

import com.gp.currencyexchange.enums.Currencies;
import com.gp.currencyexchange.feignClient.Exchange;
import com.gp.currencyexchange.mapper.CurrencyConversionMapper;
import com.gp.currencyexchange.mapper.CurrenciesMapper;
import com.gp.currencyexchange.web.response.CurrenciesResponse;
import com.gp.currencyexchange.web.response.CurrencyPreferencesResponse;
import com.gp.currencyexchange.web.response.CurrencyConversionResponse;
import com.gp.currencyexchange.web.response.CurrencyComparisonResponse;
import com.gp.currencyexchange.service.ExchangeService;
import com.gp.currencyexchange.validators.InputValidator;
import com.gp.currencyexchange.dto.CurrencyDto;
import com.gp.currencyexchange.dto.ImageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private Exchange exchange;
    @Autowired
    private InputValidator validator;

    @Autowired
    private CurrencyConversionMapper currencyComparisonMapper;

    @Autowired
    private CurrenciesMapper currenciesMapper;

    private final Logger log = LoggerFactory.getLogger(ExchangeServiceImpl.class);



    @Cacheable(cacheNames = "CurrenciesExchange")
    public CurrenciesResponse getLatest(String base)  {
        //check if currency in enum or not
        validator.validateCurrency(base);
        return currenciesMapper.mapToResponse(exchange.getLatestExchangeRate(base));
    }


    @Cacheable(cacheNames = "CurrenciesExchange")
    public CurrencyConversionResponse convert(String base, String target, String amount)  {
        validator.validateAmount(amount);
        validator.validateCurrency(base, target);
        CurrencyConversionResponse conversionData = currencyComparisonMapper.mapToResponse(exchange.getPairExchangeRate(base, target));
        conversionData.setConversionValue(Double.parseDouble(conversionData.getConversionRate()) * Double.parseDouble(amount) + "");
        return conversionData;
    }

    @Cacheable(cacheNames = "CurrenciesExchange")
    public CurrenciesResponse getHistoricalExchangeRate(String base, String year, String month, String day)  {
        validator.validateCurrency(base);
        validator.validateDate(year, month, day);
        return currenciesMapper.mapToResponse(exchange.getHistoryExchangeRate(base, year, month, day));
    }

    @Cacheable(cacheNames = "CurrenciesExchange")
    public List<ImageDto> getImageDtos() {
        List<ImageDto> result = new ArrayList<>();
        // for every currency return map consisting of (currency name : image link)
        Stream.of(Currencies.values()).forEach(c -> result.add(ImageDto.builder().currency(c.name()).flag("https://www.countryflagicons.com/FLAT/64/" + c.getCountry() + ".png").build()));
        return result;
    }

    @Cacheable(cacheNames = "CurrenciesExchange")
    public CurrencyComparisonResponse getCompareDto(String base, String target1, String target2, String amount)  {
        validator.validateAmount(amount);
        validator.validateCurrency(base, target1, target2);

        // get the latest conversion rate for all currencies then limit the result to include only target1 and target2
        CurrenciesResponse latestCurrenciesValues = currenciesMapper.mapToResponse(exchange.getLatestExchangeRate(base));
        String firstConversionValue = (Double.parseDouble(latestCurrenciesValues.getConversionRates().get(target1)) * Double.parseDouble(amount)) + "";
        String secondConversionValue = (Double.parseDouble(latestCurrenciesValues.getConversionRates().get(target2)) * Double.parseDouble(amount) + "");
//        return new CurrencyComparisonResponse(firstConversionValue, secondConversionValue);
        return CurrencyComparisonResponse.builder().firstConversionValue(firstConversionValue).secondConversionValue(secondConversionValue).build();
    }

    @Cacheable(cacheNames = "CurrenciesExchange")
    public CurrencyPreferencesResponse getRates(String base_code, List<String> targets) {
        validator.validateCurrency(base_code);
        InputValidator inputValidator = validator;
        for (String target : targets) {
            inputValidator.validateCurrency(target);
        }

        // get the latest conversion rate for all currencies then limit the result to include only required targets
        CurrenciesResponse latestExchangeRates = currenciesMapper.mapToResponse(exchange.getLatestExchangeRate(base_code));
        List<CurrencyDto> list = new ArrayList<>();
        // for every target construct list of objects consisting of (currency name : conversion rate)
        targets.forEach(t -> list.add(new CurrencyDto(t, latestExchangeRates.getConversionRates().get(t), "https://www.countryflagicons.com/FLAT/64/" + Currencies.valueOf(t).getCountry() + ".png")));
        return CurrencyPreferencesResponse.builder().baseCurrency(base_code).targets(list).build();
    }

    @Scheduled(cron = "0 0 * * * *")
    @CacheEvict(cacheNames = "CurrenciesExchange", allEntries = true)
    public void clearCache() {
        log.info("Cache cleared.");
    }

    // builder
    // singlton
}
