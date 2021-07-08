package com.dio.sawcunha.peoplemanager.controller;


import com.dio.sawcunha.peoplemanager.dto.AddressDTO;
import com.dio.sawcunha.peoplemanager.exceptionmanager.enums.eMessageError;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.AddressNotFoundIDException;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.ExceptionPeopleManager;
import com.dio.sawcunha.peoplemanager.service.AddressService;
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
@RequestMapping(value = "/v1/address",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddressController {

    private final AddressService addressService;
    private final ValidBody validBody;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<AddressDTO>> findAll(){
        return ResponseEntity.ok(addressService.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AddressDTO> findById(@PathVariable Long id, @RequestParam(value = "person", defaultValue = "false") boolean inforPerson) throws AddressNotFoundIDException {
        return ResponseEntity.ok(addressService.findById(id, inforPerson));
    }

    @GetMapping("/person/{idPerson}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<AddressDTO>> findByPersonId(@PathVariable Long idPerson) throws AddressNotFoundIDException {
        return ResponseEntity.ok(addressService.findByidPerson(idPerson));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws AddressNotFoundIDException {
        addressService.delete(id);
    }

    @PostMapping("/person/{idPerson}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AddressDTO> createAddressPerson(@PathVariable Long idPerson, @RequestBody @Valid AddressDTO addressDTO, BindingResult result) throws ExceptionPeopleManager {
        validBody.validBody(result, eMessageError.ADDRESS_NOT_VALID);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.createAddressPerson(idPerson,addressDTO));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AddressDTO> updateAddressPerson(@PathVariable Long id, @RequestBody @Valid AddressDTO addressDTO, BindingResult result) throws ExceptionPeopleManager{
        validBody.validBody(result, eMessageError.ADDRESS_NOT_VALID);
        return ResponseEntity.ok(addressService.updateAddressPerson(id, addressDTO));
    }

}
