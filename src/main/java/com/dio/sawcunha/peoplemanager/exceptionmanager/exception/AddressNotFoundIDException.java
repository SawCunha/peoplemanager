package com.dio.sawcunha.peoplemanager.exceptionmanager.exception;

import com.dio.sawcunha.peoplemanager.exceptionmanager.enums.eMessageError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AddressNotFoundIDException extends ExceptionPeopleManager{

    public AddressNotFoundIDException() {
        super(eMessageError.ADDRESS_NOT_FOUND_ID.getMessage());
        this.messageError = eMessageError.ADDRESS_NOT_FOUND_ID;
    }
}
