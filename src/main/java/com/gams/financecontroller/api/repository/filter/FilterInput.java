package com.gams.financecontroller.api.repository.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class FilterInput {

    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate DueDataMin;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate DueDataMax;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDataMin() {
        return DueDataMin;
    }

    public void setDueDataMin(LocalDate dueDataMin) {
        DueDataMin = dueDataMin;
    }

    public LocalDate getDueDataMax() {
        return DueDataMax;
    }

    public void setDueDataMax(LocalDate dueDataMax) {
        DueDataMax = dueDataMax;
    }
}
