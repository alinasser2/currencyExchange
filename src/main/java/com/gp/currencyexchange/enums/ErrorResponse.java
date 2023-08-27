package com.gp.currencyexchange.enums;

public enum ErrorResponse {
    INVALID_DATE("Invalid date"),
    INVALID_AMOUNT("Amount must be positive number."),
    INVALID_CURRENCY("Invalid currency ");

    private final String message;

    ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
