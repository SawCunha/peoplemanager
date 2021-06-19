package com.dio.sawcunha.peoplemanager.dto.mapper;

import com.dio.sawcunha.peoplemanager.dto.PersonDTO;
import com.dio.sawcunha.peoplemanager.model.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person toModel(PersonDTO personDTO);
    PersonDTO toDTO(Person person);
    List<PersonDTO> toDTOs(List<Person> people);

}
