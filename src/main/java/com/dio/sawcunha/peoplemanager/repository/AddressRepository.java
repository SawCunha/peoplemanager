package com.dio.sawcunha.peoplemanager.repository;

import com.dio.sawcunha.peoplemanager.dto.AddressDTO;
import com.dio.sawcunha.peoplemanager.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("SELECT NEW com.dio.sawcunha.peoplemanager.dto.AddressDTO" +
            "(a.id, a.zipCode, a.city, a.addressName, a.state, a.street, a.country, a.number, a.block, a.complement, a.reference) " +
           "FROM Address a WHERE a.person.id = :idPerson")
    Optional<List<AddressDTO>> findByIDPersonDTO(Long idPerson);

    @Query("SELECT NEW com.dio.sawcunha.peoplemanager.dto.AddressDTO" +
            "(a.id, a.zipCode, a.city, a.addressName, a.state, a.street, a.country, a.number, a.block, a.complement, a.reference) " +
            " FROM Address a WHERE a.id = :id")
    Optional<AddressDTO> findByIdDTO(Long id);

    @Query("SELECT a FROM Address a WHERE a.person.id = :idPerson")
    Optional<Address> findByIDPerson(Long idPerson);

}
