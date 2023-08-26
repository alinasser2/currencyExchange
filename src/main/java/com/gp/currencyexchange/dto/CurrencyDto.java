package com.gp.currencyexchange.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyDto
{
    private String currency;
    private String exchange_rate;
    private String flag;
}
