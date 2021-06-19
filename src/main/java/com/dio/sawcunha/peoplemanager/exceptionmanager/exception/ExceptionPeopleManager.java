package com.dio.sawcunha.peoplemanager.exceptionmanager.exception;

import com.dio.sawcunha.peoplemanager.exceptionmanager.enums.eMessageError;
import com.dio.sawcunha.peoplemanager.exceptionmanager.model.ExceptionResponse;
import lombok.Getter;

@Getter
public class ExceptionPeopleManager extends Exception{

    protected eMessageError messageError;

    public ExceptionPeopleManager(String message) {
        super(message);
    }

    public ExceptionResponse createResponse(){
        return ExceptionResponse.builder()
                .codErro(messageError.getCodErro())
                .message(messageError.getMessage())
                .build();
    }
}
