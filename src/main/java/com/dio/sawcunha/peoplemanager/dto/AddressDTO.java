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
    @NotEmpty(message = "It is mandatory to inform the Zip Code")
    private String zipCode;
    @NotEmpty(message = "It is mandatory to inform the City")
    private String city;
    @NotEmpty(message = "It is mandatory to inform the name the Address")
    private String addressName;
    @NotEmpty(message = "It is mandatory to inform the State")
    private String state;
    @NotEmpty(message = "It is mandatory to inform the Street")
    private String street;
    @NotEmpty(message = "It is mandatory to inform the Country")
    private String country;
    @NotNull(message = "The house number must be greater than 1.")
    @Positive(message = "The house number must be greater than 1.")
    private Integer number;
    private String block;
    private String complement;
    private String reference;


}
