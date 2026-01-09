package com.PocketIdentityDirectory.feign.dtos.helpers;

public class IASName {

    private String familyName;

    private String givenName;

    public IASName(String familyName, String givenName) {
        this.familyName = familyName;
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }
}
