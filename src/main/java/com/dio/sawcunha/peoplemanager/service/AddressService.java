package com.dio.sawcunha.peoplemanager.service;

import com.dio.sawcunha.peoplemanager.dto.AddressDTO;
import com.dio.sawcunha.peoplemanager.dto.mapper.AddressMapper;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.AddressNotFoundIDException;
import com.dio.sawcunha.peoplemanager.model.Address;
import com.dio.sawcunha.peoplemanager.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Transactional(readOnly = true)
    public List<AddressDTO> findAll(){
        return addressMapper.toDTOs(addressRepository.findAll());
    }

    public AddressDTO findById(Long id) throws AddressNotFoundIDException {
        return addressMapper.toDTO(addressRepository.findById(id).orElseThrow(AddressNotFoundIDException::new));
    }

    public AddressDTO findByidPerson(Long idPerson) throws AddressNotFoundIDException {
        return addressMapper.toDTO(addressRepository.findByIDPerson(idPerson).orElseThrow(AddressNotFoundIDException::new));
    }

    public void delete(Long id) throws AddressNotFoundIDException {
        Address address = addressRepository.findById(id).orElseThrow(AddressNotFoundIDException::new);
        addressRepository.delete(address);
    }
}
