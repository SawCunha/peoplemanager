package com.dio.sawcunha.peoplemanager.dto;

import com.dio.sawcunha.peoplemanager.enums.eSex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneDTO {

    private Long id;

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

    private PhonePersonDTO person;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PhonePersonDTO {
        private Long id;

        @NotNull
        @NotEmpty
        private String name;
        @NotNull
        @NotEmpty
        private String surname;
        @NotEmpty
        @CPF(message = "The CPF informed must be valid")
        private String cpf;
        @NotNull
        private LocalDate birthday;
        @NotNull
        @NotEmpty
        @Email(message = "The e-mail informed must be valid")
        private String email;
        @NotNull
        @NotEmpty
        private String description;
        @NotNull
        private eSex sex;
    }
}
