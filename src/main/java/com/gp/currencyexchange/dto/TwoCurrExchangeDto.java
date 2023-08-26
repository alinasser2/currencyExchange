package com.gp.currencyexchange.dto;

import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TwoCurrExchangeDto {
//    private String base_code;
//    private String first_target_code;
//    private String second_target_code;
    private String first_Conversion_value;
    private String second_Conversion_value;
}
