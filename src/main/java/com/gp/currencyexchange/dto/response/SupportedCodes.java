package com.gp.currencyexchange.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;


@Data
@ToString
@NoArgsConstructor
public class SupportedCodes {
    private List<List<String>> supported_codes;

    public SupportedCodes(List<List<String>> supported_codes) {
        this.supported_codes = supported_codes.stream().filter(e -> e.get(0).equals("USD")).toList();
    }
}
