package com.dio.sawcunha.peoplemanager.dto.mapper;

import com.dio.sawcunha.peoplemanager.dto.AddressDTO;
import com.dio.sawcunha.peoplemanager.model.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toModel(AddressDTO addressDTO);
    AddressDTO toDTO(Address address);
    List<AddressDTO> toDTOs(List<Address> addresses);

}
