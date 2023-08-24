package com.gp.currencyexchange.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Currencies {
    USD("US"),
    EUR("EU"),
    GBP("GB"),
    JPY("JP"),
    SAR("SA"),
    AED("AE"),
    KWD("KW"),
    BHD("BH"),
    OMR("OM"),
    QAR("QA");

    final String country;
}
