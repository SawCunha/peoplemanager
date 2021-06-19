package com.dio.sawcunha.peoplemanager.service;

import com.dio.sawcunha.peoplemanager.dto.PersonDTO;
import com.dio.sawcunha.peoplemanager.dto.mapper.PersonMapper;
import com.dio.sawcunha.peoplemanager.enums.eMessageError;
import com.dio.sawcunha.peoplemanager.exceptionmanager.PersonNotFoundCPF;
import com.dio.sawcunha.peoplemanager.model.Person;
import com.dio.sawcunha.peoplemanager.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public List<PersonDTO> findAll(){
        return new ArrayList<>();
    }

    public PersonDTO findByCpf(String cpf) throws PersonNotFoundCPF {
        Person person = personRepository.findByCpf(cpf).orElseThrow(() -> new PersonNotFoundCPF(eMessageError.PEOPLE_NOT_FOUND_CPF));
        return personMapper.toDTO(person);
    }

}
