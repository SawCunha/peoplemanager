package com.dio.sawcunha.peoplemanager.exceptionmanager.exception;


import com.dio.sawcunha.peoplemanager.exceptionmanager.enums.eMessageError;

public class PersonAlreadyRegistersCpfException extends ExceptionPeopleManager{

    public PersonAlreadyRegistersCpfException() {
        super(eMessageError.PERSON_ALREADY_REGISTERS_CPF.getMessage());
        this.messageError = eMessageError.PERSON_ALREADY_REGISTERS_CPF;
    }
}
