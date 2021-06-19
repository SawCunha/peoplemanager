package com.dio.sawcunha.peoplemanager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum eSex {
    MALE("Male"),
    FEMALE("Female"),
    HOMOSEXUAL("Homosexual"),
    BISEXUAL("Bisexual"),
    ASEXUAL("Asexual"),
    PANSEXUAL("Pansexual");

    private final String sex;

}
