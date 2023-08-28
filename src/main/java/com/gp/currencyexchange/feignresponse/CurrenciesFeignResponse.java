package com.gp.currencyexchange.feignresponse;

import com.gp.currencyexchange.enums.Currencies;
import lombok.*;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CurrenciesFeignResponse {
    private String base_code;
    private Map<String, String> conversion_rates;

    public CurrenciesFeignResponse(String base_code, Map<String, String> conversion_rates) {
        setBase_code(base_code);
        setConversion_rates(conversion_rates);
    }

    public void setConversion_rates(Map<String, String> conversion_rates) {
        this.conversion_rates = conversion_rates.entrySet().stream().filter(e -> Arrays.stream(Currencies.values()).map(Currencies::name).toList().contains(e.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
