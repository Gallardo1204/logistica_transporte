package com.logistica.transporte.config.validators;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PasswordValidator.class})
@Documented
public @interface PasswordValidation {
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends javax.validation.Payload>[] payload() default {};
}