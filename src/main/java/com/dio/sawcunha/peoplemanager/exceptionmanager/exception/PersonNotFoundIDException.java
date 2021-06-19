package com.dio.sawcunha.peoplemanager.exceptionmanager.exception;

import com.dio.sawcunha.peoplemanager.exceptionmanager.enums.eMessageError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PersonNotFoundIDException extends ExceptionPeopleManager{

    public PersonNotFoundIDException() {
        super(eMessageError.PERSON_NOT_FOUND_ID.getMessage());
        this.messageError = eMessageError.PERSON_NOT_FOUND_ID;
    }
}
