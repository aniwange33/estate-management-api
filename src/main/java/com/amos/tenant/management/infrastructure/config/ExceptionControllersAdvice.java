package com.amos.tenant.management.infrastructure.config;

import com.amos.tenant.management.infrastructure.data.ErrorResponse;
import com.amos.tenant.management.usecases.exceptions.GenericInputErrorException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionControllersAdvice extends ResponseEntityExceptionHandler{

    @ExceptionHandler(GenericInputErrorException.class)
    public ResponseEntity<ErrorResponse> handleGenericTextExceptions(GenericInputErrorException e, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(LocalDateTime.now(), e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleExceptions(GenericInputErrorException e, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(LocalDateTime.now(), request.getDescription(true)), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(LocalDateTime.now(), ex.getBindingResult().toString()), HttpStatus.BAD_REQUEST);
    }

}
