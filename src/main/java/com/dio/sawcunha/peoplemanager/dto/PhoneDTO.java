package com.dio.sawcunha.peoplemanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneDTO {

    private Long id;

    //@JsonIgnore
    private PeopleDTO people;

    @NotNull
    @NotEmpty
    @Positive
    @Size(min = 1, max = 3)
    private Integer prefixInternattional;
    @Size(min = 1, max = 2)
    private Integer prefixNational;
    @NotNull
    @NotEmpty
    private String number;

}
