package com.dio.sawcunha.peoplemanager.dto;

import com.dio.sawcunha.peoplemanager.enums.eSex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDTO {
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

    @Valid
    List<AddressDTO> addresses;
    @Valid
    List<PhoneDTO> phones;
}
