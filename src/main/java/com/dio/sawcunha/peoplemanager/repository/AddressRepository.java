package com.dio.sawcunha.peoplemanager.repository;

import com.dio.sawcunha.peoplemanager.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
