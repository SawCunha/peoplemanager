package com.dio.sawcunha.peoplemanager.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneDTO {

    private Long id;

    @JsonIgnore
    private PersonDTO person;

    @NotNull(message = "The international prefix must be between 1 to 999")
    @Positive(message = "The international prefix must be between 1 to 999")
    @Max(value = 999, message = "The international prefix must be between 1 to 999")
    private Integer prefixInternattional;

    @Positive
    @Max(value = 99,message = "The national prefix must be between 1 to 99")
    private Integer prefixNational;
    @NotNull(message = "The phone number must be entered")
    @NotEmpty(message = "The phone number must be entered")
    private String number;

}
