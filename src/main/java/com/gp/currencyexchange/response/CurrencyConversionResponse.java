package com.gp.currencyexchange.response;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversionResponse {
//    private String base_code;
//    private String target_code;
//    private String amount;
    private String conversion_rate;
    private String conversion_value;
}
