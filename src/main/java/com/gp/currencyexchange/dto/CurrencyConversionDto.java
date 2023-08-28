package com.gp.currencyexchange.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrencyConversionDto {
    private String baseCode;
    private String targetCode;
    private String conversionRate;
}
