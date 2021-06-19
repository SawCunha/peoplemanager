package com.dio.sawcunha.peoplemanager.mapper;

import com.dio.sawcunha.peoplemanager.dto.PersonDTO;
import com.dio.sawcunha.peoplemanager.dto.mapper.PersonMapper;
import com.dio.sawcunha.peoplemanager.model.Person;
import com.dio.sawcunha.peoplemanager.utils.PersonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonMapperTest {

    @Autowired
    private PersonMapper personMapper;

    @Test
    void testGivenPersonDTOThenReturnPersonEntity(){
        PersonDTO personDTO = PersonUtil.createPersonDTOFaker();
        Person person = personMapper.toModel(personDTO);

        assertEquals(personDTO.getEmail(), person.getEmail());
        assertEquals(personDTO.getBirthday(), person.getBirthday());
        assertEquals(personDTO.getName(), person.getName());
        assertEquals(personDTO.getSurname(), person.getSurname());
        assertEquals(personDTO.getSex(), person.getSex());

    }

}
