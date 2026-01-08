package com.PocketIdentityDirectory.feign.dtos.requests;

import com.PocketIdentityDirectory.feign.dtos.helpers.FeignEmail;
import com.PocketIdentityDirectory.feign.dtos.helpers.FeignName;
import com.PocketIdentityDirectory.feign.dtos.helpers.SAPExtensionHelper;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UpdateIASUserRequest {


    private List<FeignEmail> emails;

    private FeignName name;

    private String userName;

    private boolean active;

    private String userType;

    private String company;

//    private List<Address> addresses;

    @JsonProperty("urn:ietf:params:scim:schemas:extension:sap:2.0:User")
    private SAPExtensionHelper extension;



    public List<FeignEmail> getEmails() {
        return emails;
    }

    public void setEmails(List<FeignEmail> emails) {
        this.emails = emails;
    }

    public FeignName getName() {
        return name;
    }

    public void setName(FeignName name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

//    public List<Address> getAddresses() {
//        return addresses;
//    }
//
//    public void setAddresses(List<Address> addresses) {
//        this.addresses = addresses;
//    }

    public SAPExtensionHelper getExtension() {
        return extension;
    }

    public void setExtension(SAPExtensionHelper extension) {
        this.extension = extension;
    }
}
