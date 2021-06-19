package com.dio.sawcunha.peoplemanager.exceptionmanager;

import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.PersonAlreadyRegistersCpfException;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.PersonNotFoundCPFException;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.PersonNotFoundIDException;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.PersonNotValidException;
import com.dio.sawcunha.peoplemanager.exceptionmanager.model.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

    @ExceptionHandler(PersonNotValidException.class)
    protected ResponseEntity<ExceptionResponse> handleSecurity(PersonNotValidException e){
        return ResponseEntity.badRequest().body(e.createResponse());
    }

    @ExceptionHandler(PersonAlreadyRegistersCpfException.class)
    protected ResponseEntity<ExceptionResponse> handleSecurity(PersonAlreadyRegistersCpfException e){
        return ResponseEntity.badRequest().body(e.createResponse());
    }
}
