package com.gp.currencyexchange.validators;

import com.gp.currencyexchange.enums.Currencies;
import com.gp.currencyexchange.exception.customize.BadEntryException;
import org.springframework.stereotype.Component;

@Component
public class InputValidator  {
    public void validateDate(String year, String month, String day) {
        try {
            if (year.length() != 4 || month.length() != 2 || day.length() != 2 || Integer.parseInt(month) > 12 || Integer.parseInt(month) < 1 || Integer.parseInt(day) > 31 || Integer.parseInt(day) < 1) {
                throw new BadEntryException("Invalid date");
            }
        } catch (Exception e) {
            throw new BadEntryException("Invalid date");
        }
    }

    public void validateAmount(String amount) {
        try {
            if (Double.parseDouble(amount) <= 0) {
                throw new BadEntryException("Amount must be positive number.");
            }
        } catch (Exception e) {
            throw new BadEntryException("Amount must be a number.");
        }
    }

    public void validateCurrency(String base) {
        if (!Currencies.contains(base.toUpperCase())) {
            throw new BadEntryException("Invalid currency: " + base);
        }
    }
}
