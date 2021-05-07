package com.gams.financecontroller.api.repository.input;

import com.gams.financecontroller.api.model.Input;
import com.gams.financecontroller.api.repository.filter.FilterInput;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InputRepositoryQuery {

    public Page<Input> filter(FilterInput filterInput, Pageable pageable);
}
