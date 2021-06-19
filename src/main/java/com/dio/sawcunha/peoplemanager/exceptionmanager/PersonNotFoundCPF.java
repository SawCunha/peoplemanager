package com.dio.sawcunha.peoplemanager.exceptionmanager;

import com.dio.sawcunha.peoplemanager.enums.eMessageError;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
public class PersonNotFoundCPF extends Exception{

    private final eMessageError messageError;
    public PersonNotFoundCPF(eMessageError messageError) {
        super(messageError.getMessage());
        this.messageError = messageError;
    }
}
