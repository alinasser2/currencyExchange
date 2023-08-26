package com.gp.currencyexchange.dto;

import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ManyCurrExchangeReqDto {
    private String base_code;
    private List<String> targets;
}
