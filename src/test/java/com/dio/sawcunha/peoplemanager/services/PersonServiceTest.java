package com.dio.sawcunha.peoplemanager.services;

import com.dio.sawcunha.peoplemanager.dto.PersonDTO;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.ExceptionPeopleManager;
import com.dio.sawcunha.peoplemanager.service.PersonService;
import com.dio.sawcunha.peoplemanager.utils.PersonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    void testSavePerson() throws ExceptionPeopleManager {
        PersonDTO personDTO = PersonUtil.createPersonDTOFaker();
        personDTO = personService.save(personDTO);
        PersonDTO personDTO1 = personService.findByCpf(personDTO.getCpf());
        assertEquals(personDTO.getId(),personDTO1.getId());
        assertEquals(personDTO.getCpf(),personDTO1.getCpf());
    }

}
