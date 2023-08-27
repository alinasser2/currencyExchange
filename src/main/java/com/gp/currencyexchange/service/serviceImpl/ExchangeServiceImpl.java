package com.gp.currencyexchange.service.serviceImpl;

import com.gp.currencyexchange.dto.*;
import com.gp.currencyexchange.enums.Currencies;
import com.gp.currencyexchange.exception.customize.CustomException;
import com.gp.currencyexchange.feignClient.Exchange;
import com.gp.currencyexchange.feignresponse.PairConversionResponse;
import com.gp.currencyexchange.response.CurrenciesResponse;
import com.gp.currencyexchange.response.CurrencyPreferencesResponse;
import com.gp.currencyexchange.response.CurrencyConversionResponse;
import com.gp.currencyexchange.response.CurrencyComparisonResponse;
import com.gp.currencyexchange.service.ExchangeService;
import com.gp.currencyexchange.validators.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable(cacheNames = "CurrenciesExchange")
    public CurrenciesResponse getLatest(String base)  {
        //check if currency in enum or not
        validator.validateCurrency(base);
        return exchange.getLatestExchangeRate(base);
    }


    @Cacheable(cacheNames = "CurrenciesExchange")
    public CurrencyConversionResponse convert(String base, String target, String amount)  {
        validator.validateAmount(amount);
        validator.validateCurrency(base, target);
        PairConversionResponse conversionData = exchange.getPairExchangeRate(base, target);
        return new CurrencyConversionResponse(conversionData.getConversion_rate(), (Double.parseDouble(conversionData.getConversion_rate()) * Double.parseDouble(amount)) + "");
    }

    @Cacheable(cacheNames = "CurrenciesExchange")
    public CurrenciesResponse getHistoricalExchangeRate(String base, String year, String month, String day)  {
        validator.validateCurrency(base);
        validator.validateDate(year, month, day);
        return exchange.getHistoryExchangeRate(base, year, month, day);
    }

    @Cacheable(cacheNames = "CurrenciesExchange")
    public List<ImageDto> getImageDtos() {
        List<ImageDto> result = new ArrayList<>();

        // for every currency return map consisting of (currency name : image link)
        Stream.of(Currencies.values()).forEach(c -> result.add(new ImageDto(c.name(), "https://www.countryflagicons.com/FLAT/64/" + c.getCountry() + ".png")));
        return result;
    }

    @Cacheable(cacheNames = "CurrenciesExchange")
    public CurrencyComparisonResponse getCompareDto(String base, String target1, String target2, String amount)  {
        validator.validateAmount(amount);
        validator.validateCurrency(base, target1, target2);

        // get the latest conversion rate for all currencies then limit the result to include only target1 and target2
        CurrenciesResponse latestCurrenciesValues = exchange.getLatestExchangeRate(base);
        return new CurrencyComparisonResponse((Double.parseDouble(latestCurrenciesValues.getConversion_rates().get(target1)) * Double.parseDouble(amount)) + "", (Double.parseDouble(latestCurrenciesValues.getConversion_rates().get(target2)) * Double.parseDouble(amount) + ""));
    }

    @Cacheable(cacheNames = "CurrenciesExchange")
    public CurrencyPreferencesResponse getRates(String base_code, List<String> targets) {
        // validate base and targets
        validator.validateCurrency(base_code);
        InputValidator inputValidator = validator;
        for (String target : targets) {
            inputValidator.validateCurrency(target);
        }

        // get the latest conversion rate for all currencies then limit the result to include only required targets
        CurrenciesResponse latestExchangeRates = exchange.getLatestExchangeRate(base_code);
        List<CurrencyDto> list = new ArrayList<>();
        targets.forEach(t -> list.add(new CurrencyDto(t, latestExchangeRates.getConversion_rates().get(t), "https://www.countryflagicons.com/FLAT/64/" + Currencies.valueOf(t).getCountry() + ".png")));
        return new CurrencyPreferencesResponse(base_code, list);
    }

    @CacheEvict(cacheNames = "CurrenciesExchange", allEntries = true)
    public String clearCache() {
        return "Cache cleared";
    }


}
