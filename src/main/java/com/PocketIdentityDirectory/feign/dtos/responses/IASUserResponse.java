package com.PocketIdentityDirectory.feign.dtos.responses;


import com.PocketIdentityDirectory.feign.dtos.helpers.ExtensionHelper;
import com.PocketIdentityDirectory.feign.dtos.helpers.FeignEmail;
import com.PocketIdentityDirectory.feign.dtos.helpers.FeignName;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class IASUserResponse {

    private UUID id;

    private String userName;

    private FeignName name;

    private String userType;

    private boolean active;

    private List<FeignEmail> emails;

    @JsonProperty("urn:ietf:params:scim:schemas:extension:sap:2.0:User")
    private ExtensionHelper extension;


    public ExtensionHelper getExtension() {
        return extension;
    }

    public void setExtension(ExtensionHelper extension) {
        this.extension = extension;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public FeignName getName() {
        return name;
    }

    public void setName(FeignName name) {
        this.name = name;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<FeignEmail> getEmails() {
        return emails;
    }

    public void setEmails(List<FeignEmail> emails) {
        this.emails = emails;
    }
}
