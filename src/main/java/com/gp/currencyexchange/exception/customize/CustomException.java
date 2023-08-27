package com.gp.currencyexchange.exception.customize;

import com.gp.currencyexchange.enums.ErrorResponse;

public class CustomException extends Exception{
    private final ErrorResponse errorResponse;

    public CustomException(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }
}
