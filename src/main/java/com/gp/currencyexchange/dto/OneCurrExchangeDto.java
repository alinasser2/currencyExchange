package com.gp.currencyexchange.dto;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OneCurrExchangeDto {
//    private String base_code;
//    private String target_code;
//    private String amount;
    private String conversion_rate;
    private String conversion_value;
}
