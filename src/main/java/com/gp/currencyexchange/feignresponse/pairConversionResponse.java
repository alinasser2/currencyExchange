package com.gp.currencyexchange.feignresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class pairConversionResponse {
    private String conversion_rate;
}
