package com.concesionaria.concesionaria.clases;

import java.util.*;

public class RecaptchaUtil {
    public static final Map<String, String> RECAPTCHA_ERROR_CODE = new HashMap<>();

    static {
        RECAPTCHA_ERROR_CODE.put("missing-input-secret", "Falta el parámetro secret");
        RECAPTCHA_ERROR_CODE.put("invalid-input-secret", "El parámetro secret no es válido o no está bien formado");
        RECAPTCHA_ERROR_CODE.put("missing-input-response", "Falta la respuesta");
        RECAPTCHA_ERROR_CODE.put("invalid-input-response", "La respuesta no es válida o no está bien formada");
        RECAPTCHA_ERROR_CODE.put("bad-request", "La petición no es válida o no está bien formada");
    }

}
