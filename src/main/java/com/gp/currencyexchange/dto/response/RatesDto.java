package com.gp.currencyexchange.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class RatesDto {
    private String base_code;
    private List<String> targets;
}
