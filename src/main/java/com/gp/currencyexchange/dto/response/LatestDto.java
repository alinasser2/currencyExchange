package com.gp.currencyexchange.dto.response;

import com.gp.currencyexchange.enums.Currencies;
import lombok.*;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@ToString
public class LatestDto {
    private String base_code;
    private Map<String, String> conversion_rates;
    public LatestDto(String base_code, Map<String, String> conversion_rates) {
        this.base_code = base_code;
        this.conversion_rates = conversion_rates.entrySet().stream().filter(e -> Arrays.stream(Currencies.values()).map(Currencies::name).toList().contains(e.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

}