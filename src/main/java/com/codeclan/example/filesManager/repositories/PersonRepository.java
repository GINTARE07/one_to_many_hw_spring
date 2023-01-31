package com.codeclan.example.filesManager.repositories;

import com.codeclan.example.filesManager.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
