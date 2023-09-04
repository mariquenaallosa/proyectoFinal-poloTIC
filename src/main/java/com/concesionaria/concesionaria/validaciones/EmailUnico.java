package com.concesionaria.concesionaria.validaciones;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.concesionaria.concesionaria.dto.*;
import java.lang.annotation.*;
import jakarta.validation.*;


@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = EmailUnicoValidator.class)
@Documented
public @interface EmailUnico {
    String message() default "Ya existe un usuario con este email";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
