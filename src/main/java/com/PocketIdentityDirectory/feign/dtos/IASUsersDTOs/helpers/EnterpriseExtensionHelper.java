package com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.helpers;

public class EnterpriseExtensionHelper {
    private String organization;

    public EnterpriseExtensionHelper(String organization) {
        this.organization = organization;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
