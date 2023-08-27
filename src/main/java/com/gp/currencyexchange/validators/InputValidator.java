package com.gp.currencyexchange.validators;

import com.gp.currencyexchange.enums.Currencies;
import com.gp.currencyexchange.exception.customize.BadEntryException;
import org.springframework.stereotype.Component;

@Component
public class InputValidator {
    public void validateDate(String year, String month, String day) {
        if (year.length() != 4 || Integer.parseInt(month) > 12 || Integer.parseInt(month) < 1 || Integer.parseInt(day) > 31 || Integer.parseInt(day) < 1) {
            throw new BadEntryException("Invalid date");
        }
    }

    public void validateAmount(String amount) {
        if (Double.parseDouble(amount) <= 0) {
            throw new BadEntryException("Amount must be positive number.");
        }
    }

    public void validateCurrency(String... currencies) {
        for (String currency : currencies) {
            if (!Currencies.contains(currency)) {
                throw new BadEntryException("Invalid currency: " + currency);
            }
        }
    }
}
