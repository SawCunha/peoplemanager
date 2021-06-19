package com.dio.sawcunha.peoplemanager.service;

import com.dio.sawcunha.peoplemanager.dto.PersonDTO;
import com.dio.sawcunha.peoplemanager.dto.mapper.PersonMapper;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.PersonAlreadyRegistersCpfException;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.PersonNotFoundCPFException;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.PersonNotFoundIDException;
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
        person = personRepository.save(person);

        return personMapper.toDTO(person);
    }
}
