package com.gams.financecontroller.api.repository;

import com.gams.financecontroller.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
