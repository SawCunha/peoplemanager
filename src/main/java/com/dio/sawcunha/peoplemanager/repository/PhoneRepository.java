package com.dio.sawcunha.peoplemanager.repository;

import com.dio.sawcunha.peoplemanager.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
