package com.gams.financecontroller.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "input")
public class Input {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @NotNull
    @Column(name = "dt_due")
    private LocalDate dataDue;

    @Column(name = "dt_payment")
    private LocalDate dataPayment;

    @NotNull
    private BigDecimal value;
    private String observation;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ReleaseType type;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_person")
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDataDue() {
        return dataDue;
    }

    public void setDataDue(LocalDate dataDue) {
        this.dataDue = dataDue;
    }

    public LocalDate getDataPayment() {
        return dataPayment;
    }

    public void setDataPayment(LocalDate dataPayment) {
        this.dataPayment = dataPayment;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public ReleaseType getType() {
        return type;
    }

    public void setType(ReleaseType type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Input input = (Input) o;
        return Objects.equals(id, input.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
