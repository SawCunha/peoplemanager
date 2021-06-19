package com.dio.sawcunha.peoplemanager.utils;

import com.dio.sawcunha.peoplemanager.dto.PersonDTO;
import com.dio.sawcunha.peoplemanager.enums.eSex;
import com.github.javafaker.Faker;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class PersonUtil {

    private static final Faker faker = new Faker();

    public static PersonDTO createPersonDTOFaker(){
        return PersonDTO.builder()
                .name(faker.name().fullName())
                .surname(faker.name().username())
                .cpf(faker.number().digits(14))
                .birthday(convertToLocalDateViaMilisecond(faker.date().birthday()))
                .email(faker.internet().emailAddress())
                .description(faker.name().title())
                .sex(eSex.MALE)
                .phones(List.of(createPhoneDTOFaker()))
                .addresses(List.of(createAddressDTOFaker()))
                .build();
    }

    private static PersonDTO.PersonPhoneDTO createPhoneDTOFaker(){
        return PersonDTO.PersonPhoneDTO.builder()
                .number(faker.phoneNumber().phoneNumber())
                .prefixNational(31)
                .prefixInternattional(55)
                .build();
    }

    private static PersonDTO.PersonAddressDTO createAddressDTOFaker(){
        return PersonDTO.PersonAddressDTO.builder()
                .addressName(faker.address().fullAddress())
                .city(faker.address().city())
                .street(faker.address().streetAddress())
                .number(Integer.parseInt(faker.address().streetAddressNumber()))
                .state(faker.address().state())
                .zipCode(faker.address().zipCode())
                .block(faker.address().state())
                .build();
    }

    private static LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

}
