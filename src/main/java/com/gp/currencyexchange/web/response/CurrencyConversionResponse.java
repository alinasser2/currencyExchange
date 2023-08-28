package com.gp.currencyexchange.web.response;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyConversionResponse implements Serializable {
//    private String base_code;
//    private String target_code;
//    private String amount;
    private String conversionRate;
    private String conversionValue;
}
