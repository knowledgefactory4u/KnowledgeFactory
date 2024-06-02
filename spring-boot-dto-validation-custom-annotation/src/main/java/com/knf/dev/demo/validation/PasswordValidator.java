package com.knf.dev.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator
        implements ConstraintValidator<ValidPassword, String> {

    // It contains at least 8 characters and at most 20 characters.
    // It contains at least one digit.
    // It contains at least one upper case alphabet.
    // It contains at least one lower case alphabet.
    // It contains at least one special character which includes !@#$%&*()-+=^.
    // It doesn’t contain any white space.
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value
                .matches("^(?=.*[0-9])(?=.*[a-z])" +
                        "(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$");
    }

}