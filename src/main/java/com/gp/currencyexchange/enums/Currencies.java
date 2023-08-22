package com.gp.currencyexchange.enums;


import lombok.Getter;

@Getter
public enum Currencies {
    USD("US"),
    EGP("EG"),
    GBP("GB"),
    JPY("JP"),
    SAR("SA"),
    AED("AE"),
    KWD("KW"),
    BHD("BH"),
    OMR("OM"),
    QAR("QA"),
    JOD("JO"),
    LBP("LB");

    final String country;
    Currencies(String country) {
        this.country = country;
    }
}
