package com.dio.sawcunha.peoplemanager.dto.mapper;

import com.dio.sawcunha.peoplemanager.dto.PhoneDTO;
import com.dio.sawcunha.peoplemanager.model.Phone;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhoneMapper {

    Phone toModel(PhoneDTO phoneDTO);
    PhoneDTO toDTO(Phone phone);
    List<PhoneDTO> toDTOs(List<Phone> phones);

}
