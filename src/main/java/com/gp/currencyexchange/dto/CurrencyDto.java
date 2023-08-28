package com.gp.currencyexchange.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyDto implements Serializable
{
    private String currency;
    private String exchangeRate;
    private String flag;
}
