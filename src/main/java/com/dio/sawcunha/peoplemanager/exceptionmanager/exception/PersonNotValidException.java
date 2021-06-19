package com.dio.sawcunha.peoplemanager.exceptionmanager.exception;

import com.dio.sawcunha.peoplemanager.exceptionmanager.enums.eMessageError;
import com.dio.sawcunha.peoplemanager.exceptionmanager.model.AttributeNotValid;
import com.dio.sawcunha.peoplemanager.exceptionmanager.model.ExceptionResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
public class PersonNotValidException extends ExceptionPeopleManager{

    private final List<AttributeNotValid> erros;
    public PersonNotValidException(List<AttributeNotValid> erros) {
        super(eMessageError.PERSON_NOT_VALID.getMessage());
        this.erros = erros;
        this.messageError = eMessageError.PERSON_NOT_VALID;
    }

    @Override
    public ExceptionResponse createResponse() {
        return ExceptionResponse.builder()
                .codErro(messageError.getCodErro())
                .message(messageError.getMessage())
                .validationErrors(erros)
                .build();
    }
}
