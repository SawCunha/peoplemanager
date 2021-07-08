package com.dio.sawcunha.peoplemanager.repository;

import com.dio.sawcunha.peoplemanager.dto.PhoneDTO;
import com.dio.sawcunha.peoplemanager.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

    @Query("SELECT NEW com.dio.sawcunha.peoplemanager.dto.PhoneDTO(p.id,p.prefixInternattional,p.prefixNational,p.number) FROM Phone p WHERE p.person.id = :idPerson")
    Optional<List<PhoneDTO>> findByIDPersonDTO(Long idPerson);

    @Query("SELECT NEW com.dio.sawcunha.peoplemanager.dto.PhoneDTO(p.id,p.prefixInternattional,p.prefixNational,p.number) FROM Phone p WHERE p.id = :id")
    Optional<PhoneDTO> findByIDDTO(Long id);

    @Query("SELECT p FROM Phone p WHERE p.person.id = :idPerson")
    Optional<Phone> findByIDPerson(Long idPerson);

}
