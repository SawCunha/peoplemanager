package com.dio.sawcunha.peoplemanager.service;

import com.dio.sawcunha.peoplemanager.dto.PeopleDTO;
import com.dio.sawcunha.peoplemanager.dto.mapper.PeopleMapper;
import com.dio.sawcunha.peoplemanager.enums.eMessageError;
import com.dio.sawcunha.peoplemanager.exceptionmanager.PeopleNotFoundCPF;
import com.dio.sawcunha.peoplemanager.model.People;
import com.dio.sawcunha.peoplemanager.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PeopleService {

    private final PeopleRepository peopleRepository;
    private final PeopleMapper peopleMapper;

    public List<PeopleDTO> findAll(){
        return new ArrayList<>();
    }

    public PeopleDTO findByCpf(String cpf) throws PeopleNotFoundCPF {
        People people = peopleRepository.findByCpf(cpf).orElseThrow(() -> new PeopleNotFoundCPF(eMessageError.PEOPLE_NOT_FOUND_CPF));
        return peopleMapper.toDTO(people);
    }

}
