package com.gp.currencyexchange.dto;

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
//latest API
public class AllCurrExchangeDto implements Serializable {
    private String base_code;
    private Map<String, String> conversion_rates;

    public AllCurrExchangeDto(String base_code, Map<String, String> conversion_rates) {
        setBase_code(base_code);
        setConversion_rates(conversion_rates);
    }

    public void setConversion_rates(Map<String, String> conversion_rates) {
        this.conversion_rates = conversion_rates.entrySet().stream().filter(e -> Arrays.stream(Currencies.values()).map(Currencies::name).toList().contains(e.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}