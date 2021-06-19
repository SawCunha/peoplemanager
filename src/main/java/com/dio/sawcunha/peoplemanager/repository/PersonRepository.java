package com.dio.sawcunha.peoplemanager.repository;

import com.dio.sawcunha.peoplemanager.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

    Optional<People> findByCpf(String cpf);

}
