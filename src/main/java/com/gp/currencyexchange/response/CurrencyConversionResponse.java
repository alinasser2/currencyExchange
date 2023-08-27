package com.gp.currencyexchange.response;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversionResponse implements Serializable {
//    private String base_code;
//    private String target_code;
//    private String amount;
    private String conversion_rate;
    private String conversion_value;
}
