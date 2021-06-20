package com.dio.sawcunha.peoplemanager.services;

import com.dio.sawcunha.peoplemanager.dto.PersonDTO;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.ExceptionPeopleManager;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.PersonAlreadyRegistersCpfException;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.PersonNotFoundCPFException;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.PersonNotFoundIDException;
import com.dio.sawcunha.peoplemanager.service.PersonService;
import com.dio.sawcunha.peoplemanager.utils.PersonUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonServiceTest {

    @Autowired
    private PersonService personService;
    private final static String CPF = "111.111.111-11";
    @Test
    @Order(1)
    void testSavePerson() throws ExceptionPeopleManager {
        PersonDTO personDTO = PersonUtil.createPersonDTOFaker();
        personDTO.setCpf(CPF);
        personDTO = personService.save(personDTO);
        PersonDTO personDTO1 = personService.findByCpf(personDTO.getCpf());
        assertEquals(personDTO.getId(),personDTO1.getId());
        assertEquals(personDTO.getCpf(),personDTO1.getCpf());
    }

    @Test
    @Order(2)
    void findPersonByID() throws PersonNotFoundIDException {
        PersonDTO personDTO = personService.findById(1L);
        assertEquals(personDTO.getId(),1L);
        assertNotNull(personDTO.getAddresses());
        assertNotNull(personDTO.getPhones());
    }

    @Test
    @Order(3)
    void findPersonIdException()   {
        Assertions.assertThatThrownBy(() -> {
            personService.findById(255L);
        }).isInstanceOf(PersonNotFoundIDException.class);
    }

    @Test
    @Order(4)
    void findPersonCPFException()   {
        Assertions.assertThatThrownBy(() -> {
            personService.findByCpf("NAO_POSSUI");
        }).isInstanceOf(PersonNotFoundCPFException.class);
    }

    @Test
    @Order(5)
    void testSavePersonCPFException() {
        Assertions.assertThatThrownBy(() -> {
            PersonDTO personDTO = PersonUtil.createPersonDTOFaker();
            personDTO.setCpf(CPF);
            personService.save(personDTO);
        }).isInstanceOf(PersonAlreadyRegistersCpfException.class);
    }
}
