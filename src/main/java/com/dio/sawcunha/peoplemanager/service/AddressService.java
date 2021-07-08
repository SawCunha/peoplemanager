package com.dio.sawcunha.peoplemanager.service;

import com.dio.sawcunha.peoplemanager.dto.AddressDTO;
import com.dio.sawcunha.peoplemanager.dto.mapper.AddressMapper;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.AddressNotFoundIDException;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.ExceptionPeopleManager;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.IDPathDifferentBodyException;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.PersonNotFoundIDException;
import com.dio.sawcunha.peoplemanager.model.Address;
import com.dio.sawcunha.peoplemanager.model.Person;
import com.dio.sawcunha.peoplemanager.repository.AddressRepository;
import com.dio.sawcunha.peoplemanager.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddressService {

    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;
    private final AddressMapper addressMapper;

    @Transactional(readOnly = true)
    public List<AddressDTO> findAll(){
        return addressMapper.toDTOs(addressRepository.findAll());
    }

    @Transactional(readOnly = true)
    public AddressDTO findById(Long id, boolean inforPerson) throws AddressNotFoundIDException {
        AddressDTO addressDTO;
        if(inforPerson) {
            addressDTO = addressMapper.toDTO(addressRepository.findById(id).orElseThrow(AddressNotFoundIDException::new));
        } else {
            addressDTO = addressRepository.findByIdDTO(id).orElseThrow(AddressNotFoundIDException::new);
        }
        return addressDTO;
    }

    @Transactional(readOnly = true)
    public List<AddressDTO> findByidPerson(Long idPerson) throws AddressNotFoundIDException {
        return addressRepository.findByIDPersonDTO(idPerson).orElseThrow(AddressNotFoundIDException::new);
    }

    @Transactional
    public void delete(Long id) throws AddressNotFoundIDException {
        Address address = addressRepository.findById(id).orElseThrow(AddressNotFoundIDException::new);
        addressRepository.delete(address);
    }

    @Transactional
    public AddressDTO createAddressPerson(Long idPerson, AddressDTO addressDTO) throws ExceptionPeopleManager {
        Person person = personRepository.findById(idPerson).orElseThrow(PersonNotFoundIDException::new);
        addressDTO.setPerson(null);
        Address address = addressMapper.toModel(addressDTO);
        address.setPerson(person);
        return addressMapper.toDTO(addressRepository.save(address));
    }

    @Transactional
    public AddressDTO updateAddressPerson(Long id, AddressDTO addressDTO) throws ExceptionPeopleManager {
        validIDPathAndBody(id,addressDTO);
        Address address = addressRepository.findById(id).orElseThrow(AddressNotFoundIDException::new);
        addressDTO.setPerson(null);
        Address addressUpdate = addressMapper.toModel(addressDTO);
        addressUpdate.setPerson(address.getPerson());
        addressUpdate.setId(address.getId());
        return addressMapper.toDTO(addressRepository.save(addressUpdate));
    }

    private void validIDPathAndBody(Long idAddress, AddressDTO addressDTO) throws IDPathDifferentBodyException {
        if(addressDTO.getId() == null || addressDTO.getId() == 0 ) throw new IDPathDifferentBodyException();
        if(!idAddress.equals(addressDTO.getId())) throw new IDPathDifferentBodyException();
    }
}
