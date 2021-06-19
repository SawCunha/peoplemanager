package com.dio.sawcunha.peoplemanager.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTO {

    private Long id;
    @JsonIgnore
    private PersonDTO person;
    @NotNull
    @NotEmpty
    private String zipCode;
    @NotNull
    @NotEmpty
    private String city;
    @NotNull
    @NotEmpty
    private String addressName;
    @NotNull
    @NotEmpty
    private String state;
    @NotNull
    @NotEmpty
    private String street;
    @NotNull
    @NotEmpty
    private String country;
    @NotNull
    @NotEmpty
    @Positive
    private Integer number;
    private String block;
    private String complement;
    private String reference;


}
