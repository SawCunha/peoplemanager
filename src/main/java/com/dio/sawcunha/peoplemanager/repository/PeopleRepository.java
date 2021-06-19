package com.dio.sawcunha.peoplemanager.repository;

import com.dio.sawcunha.peoplemanager.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
}
