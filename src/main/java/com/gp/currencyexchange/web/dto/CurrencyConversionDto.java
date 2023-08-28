package com.gp.currencyexchange.web.dto;

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
