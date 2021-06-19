package com.dio.sawcunha.peoplemanager.controller;


import com.dio.sawcunha.peoplemanager.dto.PeopleDTO;
import com.dio.sawcunha.peoplemanager.exceptionmanager.PeopleNotFoundCPF;
import com.dio.sawcunha.peoplemanager.service.PeopleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/people",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PeopleController {

    private final PeopleService peopleService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PeopleDTO>> findAll(){
        return ResponseEntity.of(Optional.of(peopleService.findAll()));
    }

    @GetMapping("/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PeopleDTO> findAll(@PathVariable String cpf) throws PeopleNotFoundCPF {
        return ResponseEntity.ok(peopleService.findByCpf(cpf));
    }

}
