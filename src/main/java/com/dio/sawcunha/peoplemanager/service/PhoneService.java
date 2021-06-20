package com.dio.sawcunha.peoplemanager.service;

import com.dio.sawcunha.peoplemanager.dto.PhoneDTO;
import com.dio.sawcunha.peoplemanager.dto.mapper.PhoneMapper;
import com.dio.sawcunha.peoplemanager.exceptionmanager.exception.PhoneNotFoundIDException;
import com.dio.sawcunha.peoplemanager.model.Phone;
import com.dio.sawcunha.peoplemanager.repository.PhoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PhoneService {

    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;

    @Transactional(readOnly = true)
    public List<PhoneDTO> findAll(){
        return phoneMapper.toDTOs(phoneRepository.findAll());
    }

    public PhoneDTO findById(Long id) throws PhoneNotFoundIDException {
        return phoneMapper.toDTO(phoneRepository.findById(id).orElseThrow(PhoneNotFoundIDException::new));
    }

    public PhoneDTO findByidPerson(Long idPerson) throws PhoneNotFoundIDException {
        return phoneMapper.toDTO(phoneRepository.findByIDPerson(idPerson).orElseThrow(PhoneNotFoundIDException::new));
    }

    public void delete(Long id) throws PhoneNotFoundIDException {
        Phone phone = phoneRepository.findByIDPerson(id).orElseThrow(PhoneNotFoundIDException::new);
        phoneRepository.delete(phone);
    }
}
