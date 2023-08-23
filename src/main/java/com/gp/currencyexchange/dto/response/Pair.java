package com.gp.currencyexchange.dto.response;


import lombok.*;

@Data
@ToString
public class Pair {
    private String base_code;
    private String target_code;
    private String amount;
    private String conversion_rate;
}
