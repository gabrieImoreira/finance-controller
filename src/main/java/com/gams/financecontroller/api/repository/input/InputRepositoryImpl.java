package com.gams.financecontroller.api.repository.input;

import com.gams.financecontroller.api.model.Input;
import com.gams.financecontroller.api.repository.filter.FilterInput;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class InputRepositoryImpl implements InputRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Input> filter(FilterInput filterInput) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Input> criteria = builder.createQuery(Input.class);
        Root<Input> root = criteria.from(Input.class);

        Predicate[] predicates = createRestrictions(filterInput, builder, root);
        criteria.where(predicates);

        TypedQuery<Input> query = manager.createQuery(criteria);
        return query.getResultList();
    }

    private Predicate[] createRestrictions(FilterInput filterInput, CriteriaBuilder builder, Root<Input> root) {

        List<Predicate> predicates = new ArrayList<>();

        if(!StringUtils.isEmpty(filterInput.getDescription())){
            predicates.add(builder.like(
            builder.lower(root.get("description")), "%" +  filterInput.getDescription().toLowerCase()+ "%"));
        }
        if(filterInput.getDueDataMin() != null) {
            predicates.add(
                    builder.greaterThanOrEqualTo(root.get("dataDue"), filterInput.getDueDataMin()));
        }

        if(filterInput.getDueDataMax() != null) {
            predicates.add(
                    builder.lessThanOrEqualTo(root.get("dataDue"),filterInput.getDueDataMax()));
        }

        return predicates.toArray(new Predicate[predicates.size()]);

    }
}
