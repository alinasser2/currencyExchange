package com.gp.currencyexchange.web.response;

import com.gp.currencyexchange.enums.Currencies;
import lombok.*;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CurrenciesResponse implements Serializable {
    private String baseCode;
    private Map<String, String> conversionRates;

    public CurrenciesResponse(String base_code, Map<String, String> conversion_rates) {
        setBaseCode(base_code);
        setconversionRates(conversion_rates);
    }

    public void setconversionRates(Map<String, String> conversion_rates) {
        this.conversionRates = conversion_rates.entrySet().stream().filter(e -> Arrays.stream(Currencies.values()).map(Currencies::name).toList().contains(e.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}