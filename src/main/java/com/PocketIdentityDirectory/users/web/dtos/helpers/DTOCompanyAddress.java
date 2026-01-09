package com.PocketIdentityDirectory.users.web.dtos.helpers;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DTOCompanyAddress {

    private String company;

    private String country;

    private String city;

    public DTOCompanyAddress(String company, String country, String city) {
        this.company = company;
        this.country = country;
        this.city = city;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
