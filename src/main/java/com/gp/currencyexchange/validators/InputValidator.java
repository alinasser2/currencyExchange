package com.gp.currencyexchange.validators;

import com.gp.currencyexchange.enums.Currencies;
import com.gp.currencyexchange.enums.ErrorResponse;
import com.gp.currencyexchange.exception.customize.CustomException;
import org.springframework.stereotype.Component;

import static com.gp.currencyexchange.enums.Currencies.*;

@Component
public class InputValidator {
    public void validateDate(String year, String month, String day)  {
        if (year.length() != 4 || Integer.parseInt(month) > 12 || Integer.parseInt(month) < 1 || Integer.parseInt(day) > 31 || Integer.parseInt(day) < 1) {
            throw new CustomException(ErrorResponse.INVALID_DATE);
        }
    }

    public void validateAmount(String amount)  {
        if (Double.parseDouble(amount) <= 0) {
            throw new CustomException(ErrorResponse.INVALID_AMOUNT);
        }

    }


    public void validateCurrency(String... currencies) {
        for (String currency : currencies) {
            if (!contains(currency)) {
                throw new CustomException(ErrorResponse.INVALID_CURRENCY);
            }
        }
    }
}
