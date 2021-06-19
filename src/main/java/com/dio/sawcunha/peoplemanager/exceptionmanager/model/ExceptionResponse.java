package com.dio.sawcunha.peoplemanager.exceptionmanager.model;

import lombok.*;

import java.util.List;

@Builder
@Getter
public class ExceptionResponse {
    private final String message;
    private final int codErro;
    private final List<AttributeNotValid> validationErrors;
}
