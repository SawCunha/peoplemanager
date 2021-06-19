package com.dio.sawcunha.peoplemanager.dto.mapper;

import com.dio.sawcunha.peoplemanager.dto.PeopleDTO;
import com.dio.sawcunha.peoplemanager.model.People;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PeopleMapper {

    People toModel(PeopleDTO peopleDTO);
    PeopleDTO toDTO(People people);
    List<PeopleDTO> toDTOs(List<People> people);

}
