package com.dio.sawcunha.peoplemanager.exceptionmanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExceptionResponse {
    private final String message;
    private final int codErro;
}
