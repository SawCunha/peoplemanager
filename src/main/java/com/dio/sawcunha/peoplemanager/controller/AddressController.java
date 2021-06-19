package com.dio.sawcunha.peoplemanager.controller;


import com.dio.sawcunha.peoplemanager.dto.AddressDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/address",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddressController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<AddressDTO>> findAll(){
        return ResponseEntity.of(Optional.of(new ArrayList<>()));
    }

}
