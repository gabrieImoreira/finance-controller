package com.gams.financecontroller.api.repository;

import com.gams.financecontroller.api.model.Input;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputRepository extends JpaRepository<Input, Long> {
}
