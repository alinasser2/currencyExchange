package com.gp.currencyexchange.feignresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class PairConversionResponse {
    private String base_code;
    private String target_code;
    private String conversion_rate;
}
