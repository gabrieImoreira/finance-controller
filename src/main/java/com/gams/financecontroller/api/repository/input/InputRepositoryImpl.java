package com.gams.financecontroller.api.repository.input;

import com.gams.financecontroller.api.model.Input;
import com.gams.financecontroller.api.repository.filter.FilterInput;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class InputRepositoryImpl implements InputRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Input> filter(FilterInput filterInput) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Input> criteria = builder.createQuery(Input.class);

        TypedQuery<Input> query = manager.createQuery(criteria);
        return query.getResultList();
    }
}
