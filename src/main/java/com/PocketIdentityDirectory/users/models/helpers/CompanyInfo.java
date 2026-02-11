package com.PocketIdentityDirectory.users.models.helpers;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CompanyInfo {

    private String company;

    private Country country;

    private String city;

    public CompanyInfo() {
    }

    public CompanyInfo(String company, Country country, String city) {
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
