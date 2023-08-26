package com.gp.currencyexchange.service.serviceImpl;

import com.gp.currencyexchange.dto.response.*;
import com.gp.currencyexchange.enums.Currencies;
import com.gp.currencyexchange.exception.customize.BadEntryException;
import com.gp.currencyexchange.feignClient.Exchange;
import com.gp.currencyexchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class ExchangeServiceImpl implements ExchangeService {

    private final Exchange exchange;

    public LatestDto getLatest(String base) {
        //check if currency in enum or not
        try {
            Currencies.valueOf(base);
            System.out.println("getLatest");
            return exchange.getLatestExchangeRate(base);
        } catch (IllegalArgumentException e) {
            throw new BadEntryException("Invalid currency: " + base);
        }

    }


    public ConversionDto convert(String base, String target, String amount) {
        try {
            Double.parseDouble(amount);
        } catch (Exception e) {
            throw new BadEntryException("Amount must be a number");
        }
        if (Double.parseDouble(amount) <= 0) {
            throw new BadEntryException("Amount cannot be negative");
        }
        ConversionDto pair = exchange.getPairExchangeRate(base, target);
        pair.setAmount(amount);
        System.out.println(pair);
        pair.setConversion_value((Double.parseDouble(pair.getConversion_rate()) * Double.parseDouble(amount)) + "");
        return pair;
    }

    public LatestDto getHistoricalExchangeRate(String base, String year, String month, String day) {
        return exchange.getHistoryExchangeRate(base, year, month, day);
    }

    public List<ImageDto> getImageDtos() {
        List<ImageDto> result = new ArrayList<>();
        // for every currency return map consisting of (currency name : image link)
        Stream.of(Currencies.values()).forEach(c -> result.add(new ImageDto(c.name(), "https://www.countryflagicons.com/FLAT/64/" + c.getCountry() + ".png")));
        return result;
    }

    public CompareDto getCompareDto(String base, String target1, String target2, String amount) {
        LatestDto latest = exchange.getLatestExchangeRate(base);
        // get the latest conversion rate for all currencies then limit the result to include only target1 and target2
        return new CompareDto(base, target1, target2, (Double.parseDouble(latest.getConversion_rates().get(target1)) * Double.parseDouble(amount)) + "", (Double.parseDouble(latest.getConversion_rates().get(target1)) * Double.parseDouble(amount) + ""));
    }

    public RatesResponseDto getRates(RatesDto dto) {
        LatestDto latest = exchange.getLatestExchangeRate(dto.getBase_code());
        List<Currency> list = new ArrayList<>();
        dto.getTargets().forEach(t -> list.add(new Currency(t, latest.getConversion_rates().get(t), "https://www.countryflagicons.com/FLAT/64/" + Currencies.valueOf(t).getCountry() + ".png")));
        return new RatesResponseDto(dto.getBase_code(), list);
    }


}