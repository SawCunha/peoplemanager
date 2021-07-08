package com.dio.sawcunha.peoplemanager.controller;


import com.dio.sawcunha.peoplemanager.dto.PhoneDTO;
import com.dio.sawcunha.peoplemanager.exceptionmanager.enums.eMessageError;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.ExceptionPeopleManager;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.PhoneNotFoundIDException;
import com.dio.sawcunha.peoplemanager.service.PhoneService;
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

@RestController
@RequestMapping(value = "/v1/phone",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PhoneController {

    private final PhoneService phoneService;
    private final ValidBody validBody;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PhoneDTO>> findAll(){
        return ResponseEntity.ok(phoneService.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PhoneDTO> findById(@PathVariable Long id, @RequestParam(value = "person", defaultValue = "false") boolean inforPerson) throws PhoneNotFoundIDException {
        return ResponseEntity.ok(phoneService.findById(id, inforPerson));
    }

    @GetMapping("/person/{idPerson}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PhoneDTO>> findByPersonId(@PathVariable Long idPerson) throws PhoneNotFoundIDException {
        return ResponseEntity.ok(phoneService.findByidPerson(idPerson));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws PhoneNotFoundIDException {
        phoneService.delete(id);
    }

    @PostMapping("/person/{idPerson}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PhoneDTO> createPhonePerson(@PathVariable Long idPerson, @RequestBody @Valid PhoneDTO phoneDTO, BindingResult result) throws ExceptionPeopleManager {
        validBody.validBody(result, eMessageError.PHONE_NOT_VALID);
        return ResponseEntity.status(HttpStatus.CREATED).body(phoneService.createPhonePerson(idPerson,phoneDTO));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PhoneDTO> updatePhonePerson(@PathVariable Long id, @RequestBody @Valid PhoneDTO phoneDTO, BindingResult result) throws ExceptionPeopleManager{
        validBody.validBody(result, eMessageError.PHONE_NOT_VALID);
        return ResponseEntity.ok(phoneService.updatePhonePerson(id, phoneDTO));
    }

}
