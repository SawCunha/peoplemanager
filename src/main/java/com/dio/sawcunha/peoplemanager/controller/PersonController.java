package com.dio.sawcunha.peoplemanager.controller;


import com.dio.sawcunha.peoplemanager.dto.PersonDTO;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.ExceptionPeopleManager;
import com.dio.sawcunha.peoplemanager.service.PersonService;
import com.dio.sawcunha.peoplemanager.util.ValidBody;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(description = "Returns all registered people.")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PersonDTO>> findAll(){
        return ResponseEntity.of(Optional.of(personService.findAll()));
    }

    @Operation(description = "Returns the person according to the ID entered")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PersonDTO> findById(@PathVariable Long id) throws ExceptionPeopleManager {
        return ResponseEntity.ok(personService.findById(id));
    }

    @Operation(description = "Returns the person according to the CPF informed")
    @GetMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PersonDTO> findByCpf(@PathVariable String cpf) throws ExceptionPeopleManager {
        return ResponseEntity.ok(personService.findByCpf(cpf));
    }

    @Operation(description = "Creates a person and returns the created person.")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PersonDTO> save(@RequestBody @Valid PersonDTO personDTO, BindingResult result) throws ExceptionPeopleManager{
        validBody.validBody(result);
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(personDTO));
    }

    @Operation(description = "Update person, returned person updated.")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PersonDTO> update(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO, BindingResult result) throws ExceptionPeopleManager{
        validBody.validBody(result);
        return ResponseEntity.ok(personService.update(id, personDTO));
    }

    @Operation(description = "Erase the person.")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ExceptionPeopleManager{
        personService.delete(id);
    }

}
