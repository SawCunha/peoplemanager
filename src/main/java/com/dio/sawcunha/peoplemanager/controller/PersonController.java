package com.dio.sawcunha.peoplemanager.controller;


import com.dio.sawcunha.peoplemanager.dto.PersonDTO;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.ExceptionPeopleManager;
import com.dio.sawcunha.peoplemanager.service.PersonService;
import com.dio.sawcunha.peoplemanager.util.ValidBody;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/person",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonService personService;
    private final ValidBody validBody;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PersonDTO>> findAll(){
        return ResponseEntity.of(Optional.of(personService.findAll()));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PersonDTO> findById(@PathVariable Long id) throws ExceptionPeopleManager {
        return ResponseEntity.ok(personService.findById(id));
    }

    @GetMapping("/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PersonDTO> findByCpf(@PathVariable String cpf) throws ExceptionPeopleManager {
        return ResponseEntity.ok(personService.findByCpf(cpf));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PersonDTO> save(@RequestBody @Valid PersonDTO personDTO, BindingResult result) throws ExceptionPeopleManager{
        validBody.validBody(result);
        return ResponseEntity.ok(personService.save(personDTO));
    }

}
