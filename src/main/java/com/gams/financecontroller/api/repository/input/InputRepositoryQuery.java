package com.gams.financecontroller.api.repository.input;

import com.gams.financecontroller.api.model.Input;
import com.gams.financecontroller.api.repository.filter.FilterInput;
import org.apache.coyote.http11.InputFilter;

import java.util.List;

public interface InputRepositoryQuery {

    public List<Input> filter(FilterInput filterInput);
}
