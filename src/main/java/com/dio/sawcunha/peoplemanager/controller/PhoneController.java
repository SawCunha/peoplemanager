package com.dio.sawcunha.peoplemanager.controller;


import com.dio.sawcunha.peoplemanager.dto.PhoneDTO;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.PhoneNotFoundIDException;
import com.dio.sawcunha.peoplemanager.service.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/phone",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PhoneDTO>> findAll(){
        return ResponseEntity.ok(phoneService.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PhoneDTO> findById(@PathVariable Long id) throws PhoneNotFoundIDException {
        return ResponseEntity.ok(phoneService.findById(id));
    }

    @GetMapping("/person/{idPerson}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PhoneDTO> findByPersonId(@PathVariable Long idPerson) throws PhoneNotFoundIDException {
        return ResponseEntity.ok(phoneService.findByidPerson(idPerson));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws PhoneNotFoundIDException {
        phoneService.delete(id);
    }

}
