package com.gp.currencyexchange.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum ErrorResponse {
    INVALID_DATE("Invalid date"),
    INVALID_AMOUNT("Amount must be positive number."),
    INVALID_CURRENCY("Invalid currency ");

    private final String message;

    ErrorResponse(String message) {
        this.message = message;
    }

}
