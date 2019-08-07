package com.example.dionisiomoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dionisiomoney.api.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
