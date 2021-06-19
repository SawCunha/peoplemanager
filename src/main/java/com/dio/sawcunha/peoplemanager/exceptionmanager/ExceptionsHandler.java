package com.dio.sawcunha.peoplemanager.exceptionmanager;

import com.dio.sawcunha.peoplemanager.exceptionmanager.model.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PersonNotFoundCPF.class)
    protected ResponseEntity<ExceptionResponse> handleSecurity(PersonNotFoundCPF e){
        return ResponseEntity.badRequest().body(new ExceptionResponse(e.getMessageError().getMessage(),e.getMessageError().getCodErro()));
    }
}
