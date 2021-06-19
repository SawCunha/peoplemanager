package com.dio.sawcunha.peoplemanager.exceptionmanager.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum eMessageError {
    PERSON_NOT_FOUND_CPF(1,"The person of this CPF was not found."),
    PERSON_NOT_FOUND_ID(2,"The person of this CPF was not found."),
    PERSON_NOT_VALID(3,"It is not possible to register the person, the data entered is not valid."),
    PERSON_ALREADY_REGISTERS_CPF(4,"Person already registers with this CPF.");

    private final int codErro;
    private final String message;
}
