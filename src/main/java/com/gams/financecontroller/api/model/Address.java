package com.gams.financecontroller.api.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Address {

    private String publicarea; //logradouro
    private String number;
    private String complement;
    private String district; //bairro
    private String zipcode; //cep
    private String city;
    private String state;


    public String getPublicarea() {
        return publicarea;
    }

    public void setPublicarea(String publicarea) {
        this.publicarea = publicarea;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZipCode() {
        return zipcode;
    }

    public void setZipCode(String zipCode) {
        this.zipcode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
