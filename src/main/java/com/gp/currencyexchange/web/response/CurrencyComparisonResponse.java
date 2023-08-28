package com.gp.currencyexchange.web.response;

import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyComparisonResponse implements Serializable {
//    private String base_code;
//    private String first_target_code;
//    private String second_target_code;
    private String firstConversionValue;
    private String secondConversionValue;
}
