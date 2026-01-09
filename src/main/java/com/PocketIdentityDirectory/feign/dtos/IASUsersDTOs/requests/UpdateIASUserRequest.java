package com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.requests;

import com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.helpers.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class UpdateIASUserRequest {

    private final String[] schemas = new String[]{"urn:ietf:params:scim:schemas:core:2.0:User", "urn:ietf:params:scim:schemas:extension:sap:2.0:User", "urn:ietf:params:scim:schemas:extension:enterprise:2.0:User"};

    private UUID id;

    private List<IASEmail> emails;

    private IASName name;

    private String userName;

    private boolean active;

    private String userType;

    @JsonProperty("urn:ietf:params:scim:schemas:extension:enterprise:2.0:User")
    private EnterpriseExtensionHelper entExtension;

    private List<IASAddress> addresses;

    @JsonProperty("urn:ietf:params:scim:schemas:extension:sap:2.0:User")
    private SAPExtensionHelper extension;

    public EnterpriseExtensionHelper getEntExtension() {
        return entExtension;
    }

    public void setEntExtension(EnterpriseExtensionHelper entExtension) {
        this.entExtension = entExtension;
    }

    public String[] getSchemas() {
        return schemas;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<IASEmail> getEmails() {
        return emails;
    }

    public void setEmails(List<IASEmail> emails) {
        this.emails = emails;
    }

    public IASName getName() {
        return name;
    }

    public void setName(IASName name) {
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

    public List<IASAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<IASAddress> addresses) {
        this.addresses = addresses;
    }

    public SAPExtensionHelper getExtension() {
        return extension;
    }

    public void setExtension(SAPExtensionHelper extension) {
        this.extension = extension;
    }
}
