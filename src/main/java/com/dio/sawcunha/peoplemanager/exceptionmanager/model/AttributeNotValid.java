package com.dio.sawcunha.peoplemanager.exceptionmanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AttributeNotValid {

    private final String attribute;
    private final String message;

}
