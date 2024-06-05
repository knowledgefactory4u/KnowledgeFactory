package com.knf.dev.demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = URLValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidURL {

    String message() default "URL is invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
