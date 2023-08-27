package com.gp.currencyexchange.exception.customize;

import com.gp.currencyexchange.enums.ErrorResponse;
import lombok.Getter;

@Getter
public class CustomException extends Exception{
    private final ErrorResponse errorResponse;

    public CustomException(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

}
