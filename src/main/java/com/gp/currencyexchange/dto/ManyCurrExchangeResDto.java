package com.gp.currencyexchange.dto;

import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ManyCurrExchangeResDto {
    private String base_currency;
    private List<CurrencyDto> targets;
}
