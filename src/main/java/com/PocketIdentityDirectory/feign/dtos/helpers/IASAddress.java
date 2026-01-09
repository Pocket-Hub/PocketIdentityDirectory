package com.PocketIdentityDirectory.feign.dtos.helpers;

public class IASAddress {

    private String country;

    private String locality;

    private String type;

    public IASAddress(String country, String locality, String type) {
        this.country = country;
        this.locality = locality;
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
