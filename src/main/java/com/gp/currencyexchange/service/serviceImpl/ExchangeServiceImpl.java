package com.gp.currencyexchange.service.serviceImpl;

import com.gp.currencyexchange.dto.*;
import com.gp.currencyexchange.enums.Currencies;
import com.gp.currencyexchange.exception.customize.BadEntryException;
import com.gp.currencyexchange.feignClient.Exchange;
import com.gp.currencyexchange.feignresponse.PairConversionResponse;
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

    public AllCurrExchangeDto getLatest(String base) {
        return exchange.getLatestExchangeRate(base);
    }


    public OneCurrExchangeDto convert(String base, String target, String amount) {
        try {
            Double.parseDouble(amount);
        } catch (Exception e) {
            throw new BadEntryException("Amount can't be a number");
        }
        if (Double.parseDouble(amount) <= 0) {
            throw new BadEntryException("Amount cannot be negative");
        }
        PairConversionResponse conversionData = exchange.getPairExchangeRate(base, target);
        return new OneCurrExchangeDto(conversionData.getConversion_rate(),(Double.parseDouble(conversionData.getConversion_rate()) * Double.parseDouble(amount)) + "");
    }

    public AllCurrExchangeDto getHistoricalExchangeRate(String base, String year, String month, String day) {
        return exchange.getHistoryExchangeRate(base, year, month, day);
    }

    public List<ImageDto> getImageDtos() {
        List<ImageDto> result = new ArrayList<>();
        // for every currency return map consisting of (currency name : image link)
        Stream.of(Currencies.values()).forEach(c -> result.add(new ImageDto(c.name(), "https://www.countryflagicons.com/FLAT/64/" + c.getCountry() + ".png")));
        return result;
    }

    public TwoCurrExchangeDto getCompareDto(String base, String target1, String target2, String amount) {
        AllCurrExchangeDto latestCurrenciesValues = exchange.getLatestExchangeRate(base);
        // get the latest conversion rate for all currencies then limit the result to include only target1 and target2
        return new TwoCurrExchangeDto((Double.parseDouble(latestCurrenciesValues.getConversion_rates().get(target1)) * Double.parseDouble(amount)) + "", (Double.parseDouble(latestCurrenciesValues.getConversion_rates().get(target1)) * Double.parseDouble(amount) + ""));
    }

    //check if currency in enum or not
    public void validateCurrency(String currency) {
        Currencies[] currencies = Currencies.values();
        for (Currencies c : currencies) {
            if (c.name().equals(currency)) {
                return;
            }
        }
        throw new BadEntryException("Invalid currency: " + currency);
    }


    public ManyCurrExchangeResDto getRates(ManyCurrExchangeReqDto dto) {
        AllCurrExchangeDto latest = exchange.getLatestExchangeRate(dto.getBase_code());
        List<CurrencyDto> list = new ArrayList<>();
        dto.getTargets().forEach(t -> list.add(new CurrencyDto(t, latest.getConversion_rates().get(t), "https://www.countryflagicons.com/FLAT/64/" + Currencies.valueOf(t).getCountry() + ".png")));
        return new ManyCurrExchangeResDto(dto.getBase_code(), list);
    }


}