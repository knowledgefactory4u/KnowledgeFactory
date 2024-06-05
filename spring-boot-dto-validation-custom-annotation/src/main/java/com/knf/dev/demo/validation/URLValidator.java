package com.knf.dev.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class URLValidator
        implements ConstraintValidator<ValidURL, String> {


    @Override
    public boolean isValid(String url, ConstraintValidatorContext context) {

        try {
            new URL(url).toURI();
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }

        return true;
    }

}