package com.dio.sawcunha.peoplemanager.service;

import com.dio.sawcunha.peoplemanager.dto.PersonDTO;
import com.dio.sawcunha.peoplemanager.dto.mapper.PersonMapper;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.*;
import com.dio.sawcunha.peoplemanager.model.Person;
import com.dio.sawcunha.peoplemanager.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Transactional(readOnly = true)
    public List<PersonDTO> findAll(){
        return new ArrayList<>();
    }

    @Transactional(readOnly = true)
    public PersonDTO findByCpf(String cpf) throws PersonNotFoundCPFException {
        Person person = personRepository.findByCpf(cpf).orElseThrow(PersonNotFoundCPFException::new);
        return personMapper.toDTO(person);
    }

    @Transactional(readOnly = true)
    public PersonDTO findById(Long id) throws PersonNotFoundIDException {
        Person person = personRepository.findById(id).orElseThrow(PersonNotFoundIDException::new);
        return personMapper.toDTO(person);
    }

    @Transactional
    public PersonDTO save(PersonDTO personDTO) throws PersonAlreadyRegistersCpfException {
        Optional<Person> personOptional = personRepository.findByCpf(personDTO.getCpf());
        if(personOptional.isPresent()){
            throw new PersonAlreadyRegistersCpfException();
        }
        Person person = personMapper.toModel(personDTO);
        person.getAddresses().forEach(address -> address.setPerson(person));
        person.getPhones().forEach(phone -> phone.setPerson(person));
        return personMapper.toDTO(personRepository.save(person));
    }

    @Transactional
    public PersonDTO update(Long id, PersonDTO personDTO) throws ExceptionPeopleManager {
        validIDPathAndBody(id,personDTO);
        if(personRepository.existsById(id)) throw new PersonNotFoundIDException();
        personDTO.setId(id);
        Person person = personMapper.toModel(personDTO);
        person.getAddresses().forEach(address -> address.setPerson(person));
        person.getPhones().forEach(phone -> phone.setPerson(person));
        return personMapper.toDTO(personRepository.save(person));
    }

    @Transactional
    public void delete(Long id) throws PersonNotFoundIDException {
        Person person = personRepository.findById(id).orElseThrow(PersonNotFoundIDException::new);
        personRepository.delete(person);
    }

    private void validIDPathAndBody(Long idPhone, PersonDTO personDTO) throws IDPathDifferentBodyException {
        if(personDTO.getId() == null || personDTO.getId() == 0 ) throw new IDPathDifferentBodyException();
        if(!idPhone.equals(personDTO.getId())) throw new IDPathDifferentBodyException();
    }
}
