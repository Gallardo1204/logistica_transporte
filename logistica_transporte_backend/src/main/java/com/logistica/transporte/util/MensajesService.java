package com.logistica.transporte.util;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Componente para retornar los mensajes de validación
 * definidos en messages.properties
 *
 */

@Component
@RequiredArgsConstructor
public class MensajesService {

    private final MessageSource messageSource;

    public String getMensaje(String mensajeHash) {
        return messageSource.getMessage(mensajeHash, null, Locale.getDefault());
    }
}