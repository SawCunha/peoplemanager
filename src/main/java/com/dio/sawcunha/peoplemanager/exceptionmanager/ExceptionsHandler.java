package com.dio.sawcunha.peoplemanager.exceptionmanager;

import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.*;
import com.dio.sawcunha.peoplemanager.exceptionmanager.model.ExceptionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PersonNotFoundCPFException.class)
    protected ResponseEntity<ExceptionResponse> handleSecurity(PersonNotFoundCPFException e){
        return ResponseEntity.badRequest().body(e.createResponse());
    }

    @ExceptionHandler(PersonNotFoundIDException.class)
    protected ResponseEntity<ExceptionResponse> handleSecurity(PersonNotFoundIDException e){
        return ResponseEntity.badRequest().body(e.createResponse());
    }

    @ExceptionHandler(NotValidException.class)
    protected ResponseEntity<ExceptionResponse> handleSecurity(NotValidException e){
        return ResponseEntity.badRequest().body(e.createResponse());
    }

    @ExceptionHandler(PersonAlreadyRegistersCpfException.class)
    protected ResponseEntity<ExceptionResponse> handleSecurity(PersonAlreadyRegistersCpfException e){
        return ResponseEntity.badRequest().body(e.createResponse());
    }

    @ExceptionHandler(PhoneNotFoundIDException.class)
    protected ResponseEntity<ExceptionResponse> handleSecurity(PhoneNotFoundIDException e){
        return ResponseEntity.badRequest().body(e.createResponse());
    }

    @ExceptionHandler(AddressNotFoundIDException.class)
    protected ResponseEntity<ExceptionResponse> handleSecurity(AddressNotFoundIDException e){
        return ResponseEntity.badRequest().body(e.createResponse());
    }

    @ExceptionHandler(IDPathDifferentBodyException.class)
    protected ResponseEntity<ExceptionResponse> handleSecurity(IDPathDifferentBodyException e){
        return ResponseEntity.badRequest().body(e.createResponse());
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.status(status).body(
                ExceptionResponse.builder().codErro(99).message(ex.getMessage()).build()
        );
    }
}
