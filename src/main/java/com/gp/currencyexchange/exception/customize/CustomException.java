package com.gp.currencyexchange.exception.customize;

import com.gp.currencyexchange.enums.ErrorResponse;
import lombok.Getter;

@Getter
public class CustomException extends  RuntimeException{
    private final ErrorResponse errorResponse;

    public CustomException(ErrorResponse errorResponse) {
        super(errorResponse.getMessage());
        this.errorResponse = errorResponse;
    }

}
