package com.gams.financecontroller.api.repository;

import com.gams.financecontroller.api.model.Input;
import com.gams.financecontroller.api.repository.input.InputRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputRepository extends JpaRepository<Input, Long>, InputRepositoryQuery {
}
