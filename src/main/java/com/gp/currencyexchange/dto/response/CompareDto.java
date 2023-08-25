package com.gp.currencyexchange.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;



@Data
@ToString
@AllArgsConstructor
public class CompareDto {
    private String base_code;
    private String first_target_code;
    private String second_target_code;
    private String first_Conversion_value;
    private String second_Conversion_value;
}
