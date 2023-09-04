package com.concesionaria.concesionaria.validaciones;

import com.concesionaria.concesionaria.dto.RegistroDto;
import jakarta.validation.*;

public class ConfirmarValidator implements ConstraintValidator<Confirmar, Object> {

    @Override
    public void initialize(final Confirmar constraintAnnotation) {

    }

    @Override
    public boolean isValid(final Object objeto, ConstraintValidatorContext context) {
        final RegistroDto registro = (RegistroDto) objeto;
        boolean esValido = registro.getPassword().equals(registro.getConfirmar());

        if (!esValido) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("confirmar").addConstraintViolation();
        }
        return esValido;
    }
}
