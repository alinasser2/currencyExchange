package com.gp.currencyexchange.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Currency
{
    private String currency;
    private String exchange_rate;
    private String flag;
}
