package com.dio.sawcunha.peoplemanager.controller;


import com.dio.sawcunha.peoplemanager.dto.PersonDTO;
import com.dio.sawcunha.peoplemanager.exceptionmanager.PersonNotFoundCPF;
import com.dio.sawcunha.peoplemanager.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/person",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonService personService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PersonDTO>> findAll(){
        return ResponseEntity.of(Optional.of(personService.findAll()));
    }

    @GetMapping("/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PersonDTO> findAll(@PathVariable String cpf) throws PersonNotFoundCPF {
        return ResponseEntity.ok(personService.findByCpf(cpf));
    }

}
