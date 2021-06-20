package com.dio.sawcunha.peoplemanager.controller;


import com.dio.sawcunha.peoplemanager.dto.AddressDTO;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.AddressNotFoundIDException;
import com.dio.sawcunha.peoplemanager.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/address",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<AddressDTO>> findAll(){
        return ResponseEntity.ok(addressService.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AddressDTO> findById(@PathVariable Long id) throws AddressNotFoundIDException {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @GetMapping("/person/{idPerson}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AddressDTO> findByPersonId(@PathVariable Long idPerson) throws AddressNotFoundIDException {
        return ResponseEntity.ok(addressService.findByidPerson(idPerson));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws AddressNotFoundIDException {
        addressService.delete(id);
    }

}
