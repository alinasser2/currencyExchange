package com.gp.currencyexchange.service.serviceImpl;

import com.gp.currencyexchange.dto.response.CompareDto;
import com.gp.currencyexchange.dto.response.ImageDto;
import com.gp.currencyexchange.dto.response.LatestDto;
import com.gp.currencyexchange.dto.response.ConversionDto;
import com.gp.currencyexchange.enums.Currencies;
import com.gp.currencyexchange.exception.customize.InvalidCurrencyException;
import com.gp.currencyexchange.exception.customize.NegativeAmountException;
import com.gp.currencyexchange.feignClient.Exchange;
import com.gp.currencyexchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@RequiredArgsConstructor
@Service
public class ExchangeServiceImpl implements ExchangeService {

    private final Exchange exchange;

    public LatestDto getLatest(String base) {
        return exchange.getLatestExchangeRate(base);
    }

    public ConversionDto convert(String base, String target, String amount) {
        ConversionDto pair =  exchange.getPairExchangeRate(base, target);
        pair.setConversion_rate((Double.parseDouble(pair.getConversion_rate()) * Double.parseDouble(amount)) + "");
        pair.setAmount(amount);
        return pair;
    }

    public LatestDto getHistoricalExchangeRate(String base, String year, String month, String day) {
        return exchange.getHistoryExchangeRate(base, year, month, day);
    }

    public List<ImageDto> getImageDtos() {
        List<ImageDto> result = new ArrayList<>();
        // for every currency return map consisting of (currency name : image link)
        Stream.of(Currencies.values()).forEach(c -> result.add(new ImageDto(c.name(), "https://www.countryflagicons.com/FLAT/64/"+ c.getCountry() +".png")));
        return result;
    }

    public CompareDto getCompareDto(String base, String target1, String target2) {
        LatestDto latest = exchange.getLatestExchangeRate(base);
        // get the latest conversion rate for all currencies then limit the result to include only target1 and target2
        return new CompareDto(base, target1, target2, latest.getConversion_rates().get(target1), latest.getConversion_rates().get(target2));
    }

    //check if currency in enum or not
    public void validateCurrency(String currency) {
        Currencies[] currencies = Currencies.values();
        for (Currencies c : currencies) {
            if (c.name().equals(currency)) {
                return;
            }
        }
        throw new InvalidCurrencyException("Invalid currency: " + currency);
    }
    public boolean exchangeCurrency(String fromCurrency, String toCurrency, double amount) {
        if (amount <= 0) {
            throw new NegativeAmountException("Amount cannot be negative");
        }
        return true;
    }

}
