package com.gp.currencyexchange.web.response;

import com.gp.currencyexchange.dto.CurrencyDto;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyPreferencesResponse implements Serializable {
    private String baseCurrency;
    private List<CurrencyDto> targets;
}
