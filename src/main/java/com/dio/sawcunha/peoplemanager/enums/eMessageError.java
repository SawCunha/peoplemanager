package com.dio.sawcunha.peoplemanager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum eMessageError {
    PEOPLE_NOT_FOUND_CPF(1,"The person of this CPF was not found.");

    private final int codErro;
    private final String message;
}
