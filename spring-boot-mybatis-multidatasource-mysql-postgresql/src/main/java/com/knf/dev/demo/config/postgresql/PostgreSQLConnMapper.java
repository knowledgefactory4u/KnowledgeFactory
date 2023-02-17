package com.knf.dev.demo.config.postgresql;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface PostgreSQLConnMapper {

    String value() default "";
}
