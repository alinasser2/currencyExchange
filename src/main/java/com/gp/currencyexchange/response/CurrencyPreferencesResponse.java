package com.gp.currencyexchange.response;

import com.gp.currencyexchange.dto.CurrencyDto;
import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyPreferencesResponse {
    private String base_currency;
    private List<CurrencyDto> targets;
}
