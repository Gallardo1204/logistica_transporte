package com.logistica.transporte.controller;

import com.logistica.transporte.dto.RespuestaGenericaDTO;
import com.logistica.transporte.exception.ResourceNotFoundException;
import com.logistica.transporte.exception.ServiceException;
import com.logistica.transporte.util.MensajesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * Clase para manejo de excepciones
 *
 */

@RestControllerAdvice
@RequiredArgsConstructor
public class ControllerExceptionHandler {

    private final MensajesService mensajesService;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public RespuestaGenericaDTO constraintsValidationHandler(ConstraintViolationException e) {

        List<String> errors = e.getConstraintViolations().stream().map(constraintViolation -> constraintViolation.getMessage()).toList();

        return RespuestaGenericaDTO.builder().mensaje(mensajesService.getMensaje("global.error.found")).errores(errors).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RespuestaGenericaDTO methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {

        List<String> errors = e.getBindingResult().getFieldErrors().stream().map(error -> error.getDefaultMessage()).toList();

        return RespuestaGenericaDTO.builder().mensaje(mensajesService.getMensaje("global.error.found")).errores(errors).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ServiceException.class)
    public RespuestaGenericaDTO serviceExceptionHandler(ServiceException e) {
        return RespuestaGenericaDTO.builder().mensaje(e.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public RespuestaGenericaDTO resourceNotFoundException(ResourceNotFoundException e) {
        return RespuestaGenericaDTO.builder().mensaje(e.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public RespuestaGenericaDTO resourceNotFoundException(Exception e) {
        e.printStackTrace();
        return RespuestaGenericaDTO.builder().mensaje(mensajesService.getMensaje("global.internal.server.error")).build();
    }

}